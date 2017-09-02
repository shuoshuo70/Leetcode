package com.page.action;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.page.model.PageInfo;
import com.page.model.WebPage;
import com.page.serviceImpl.ServiceCallImpl;

/**
 * 继承ActionSupport,定义调用service层的方法
 * @author shuoshu
 *
 */
public class PageSupport extends ActionSupport implements Serializable {

	private static final long serialVersionUID = 7415056704592491695L;
	
	PageSupport() {
		webPage = new WebPage();
	}
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	/**
	 * 
	 * @param model : service通道
	 * @param target ： service方法
	 * @param dataMap ： 传入service的参数
	 * @return
	 */
	public Map pageCall(String model, String target, Map dataMap) {
		if(dataMap == null) {
			dataMap = new HashMap();
		}
		
		//将page信息传入dataMap
		dataMap.put(PageInfo.PAGEKEY, getPage());
		Map retMap = new ServiceCallImpl(model).call(target, dataMap);
		
		webPage.getPageInfo().setTotalSize(convertToInt(retMap.get(PageInfo.PAGETOTALSIZE)));
		
		return retMap;
	}

	private Object getPage() {
		webPage.goToPage();
		return webPage.getPageInfo();
	}

	/**
	 * 类型转换成整数
	 * @param o
	 * @return
	 */
	private int convertToInt(Object o) {
		if(o == null) {
			return 0;
		}
		
		try {
			return Integer.parseInt((String) o);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private WebPage webPage;

	public WebPage getWebPage() {
		return webPage;
	}

	public void setWebPage(WebPage webPage) {
		this.webPage = webPage;
	}
	
}
