package com.page.model;
import java.io.Serializable;

import javax.persistence.Entity;

/**
 * ҳ����ת
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
	 * ��תҳ��
	 */
	public void goToPage() {
		int startIndex = pageInfo.getStartIndex();
		int totalSize = pageInfo.getTotalSize();
		int pageSize = pageInfo.getPageSize();
		int totalPages = pageInfo.getTotalPages();
		
		/**
		 * ��ʼҳ
		 */
		if(action == null) {
			pageInfo.setStartIndex(0);
			return;
		}
		
		/**
		 * ��ҳ
		 */
		if("first".equals(action)) {
			pageInfo.setStartIndex(0);
			return;
		} 
		
		/**
		 * ǰһҳ
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
		 * ��һҳ
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
		 * βҳ
		 */
		if("last".equals(action)) {
			startIndex = goToLast();
			pageInfo.setStartIndex(startIndex);
			return;
		}
		
		/**
		 * ˢ��
		 */
		if("refresh".equals(action)) {
			pageInfo.setTotalSize(0);
		}
		
		/**
		 * ��ת���ڼ�ҳ
		 */
		if(action.matches("\\d+")) {
			int pageIndex = Integer.parseInt(action);
			
			//��ҳ
			if(pageIndex <= 1) {
				startIndex = 0;
			} 
			//βҳ
			else if(pageIndex > totalPages) {
				startIndex = goToLast();
			}
			//�м�ҳ
			else {
				startIndex = pageSize * (pageIndex - 1);
			}
			
			pageInfo.setStartIndex(startIndex);
			return;
		}
	}
	
	/**
	 * βҳ��ʼҳ��
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
