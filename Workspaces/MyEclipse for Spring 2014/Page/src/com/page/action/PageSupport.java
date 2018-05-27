package com.page.action;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.page.model.PageInfo;
import com.page.model.WebPage;
import com.page.serviceImpl.ServiceCallImpl;

/**
 * �̳�ActionSupport,�������service��ķ���
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
	 * @param model : serviceͨ��
	 * @param target �� service����
	 * @param dataMap �� ����service�Ĳ���
	 * @return
	 */
	public Map pageCall(String model, String target, Map dataMap) {
		if(dataMap == null) {
			dataMap = new HashMap();
		}
		
		//��page��Ϣ����dataMap
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
	 * ����ת��������
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
