package com.page.model;
import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 页面跳转
 * @author shuoshu
 *
 */

@Entity
public class WebPage implements Serializable{
	private static final long serialVersionUID = 8326562873861135890L;
	
	public WebPage() {
		pageInfo = new PageInfo();
		action = null;
	}
	
	/**
	 * 跳转页面
	 */
	public void goToPage() {
		int startIndex = pageInfo.getStartIndex();
		int totalSize = pageInfo.getTotalSize();
		int pageSize = pageInfo.getPageSize();
		int totalPages = pageInfo.getTotalPages();
		
		/**
		 * 起始页
		 */
		if(action == null) {
			pageInfo.setStartIndex(0);
			return;
		}
		
		/**
		 * 首页
		 */
		if("first".equals(action)) {
			pageInfo.setStartIndex(0);
			return;
		} 
		
		/**
		 * 前一页
		 */
		if("prev".equals(action)) {
			startIndex -= pageSize;
			if(startIndex < 0) {
				startIndex = 0;
			}
			pageInfo.setStartIndex(startIndex);
			return;
		}
		
		/**
		 * 下一页
		 */
		if("next".equals(action)) {
			startIndex += pageSize;
			if(startIndex > totalSize) {
				startIndex -= pageSize;
			}
			pageInfo.setStartIndex(startIndex);
			return;
		}
		
		/**
		 * 尾页
		 */
		if("last".equals(action)) {
			startIndex = goToLast();
			pageInfo.setStartIndex(startIndex);
			return;
		}
		
		/**
		 * 刷新
		 */
		if("refresh".equals(action)) {
			pageInfo.setTotalSize(0);
		}
		
		/**
		 * 跳转到第几页
		 */
		if(action.matches("\\d+")) {
			int pageIndex = Integer.parseInt(action);
			
			//首页
			if(pageIndex <= 1) {
				startIndex = 0;
			} 
			//尾页
			else if(pageIndex > totalPages) {
				startIndex = goToLast();
			}
			//中间页
			else {
				startIndex = pageSize * (pageIndex - 1);
			}
			
			pageInfo.setStartIndex(startIndex);
			return;
		}
	}
	
	/**
	 * 尾页起始页码
	 */
	private int goToLast() {
		int modValue = pageInfo.getTotalSize() % pageInfo.getPageSize();
		int startIndex = pageInfo.getTotalSize() - (modValue == 0? pageInfo.getPageSize() : modValue);
		return startIndex;
	}
	
	private PageInfo pageInfo;
	private String action;

	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
