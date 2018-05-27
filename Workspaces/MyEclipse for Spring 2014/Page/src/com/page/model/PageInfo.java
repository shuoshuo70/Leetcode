package com.page.model;
import java.io.Serializable;

import javax.persistence.Entity;

/**
 * ����ҳ��Ļ�����Ϣ
 * ��Ҫ���䵽ETB�ˣ������Ҫ���л�
 * @author shuoshu
 *
 */

@Entity
public class PageInfo implements Serializable{
	private static final long serialVersionUID = 3007133061017142157L;
	
	public static final String PAGEKEY = "PAGEKEY";
	public static final String PAGEVALUE = "PAGEVALUE";
	public static final String PAGETOTALSIZE = "PAGETOTALSIZE";
	
	/**
	 * ��ʼ��
	 */
	int startIndex;
	/**
	 * ��ǰҳҳ��
	 */
	int curPageNum;
	/**
	 * ��ҳ����
	 */
	int pageSize;
	/**
	 * �ܼ�¼��
	 */
	int totalSize;
	
	/**
	 * �����ܼ�¼������������0��dao�����²�ѯdb
	 * @return
	 */
	public void resetTotalSize() {
		totalSize = 0;
	}
	
	/**
	 * ���÷�ҳ��Ϣ�������²�ѯ�У�������ʼҳ������
	 * @return
	 */
	public void reset() {
		setStartIndex(0);
		setTotalSize(0);
	}
	
	/**
	 * ������ҳ��
	 * @return
	 */
	public int getTotalPages() {
		int totalPages = getPageSize() <= 0 ? 1 : (int)Math.ceil(getTotalSize() * 1.0 / getPageSize());
		return totalPages;
	}
	
	/**
	 * ���㵱ǰҳ�ǵڼ�ҳ
	 * @return
	 */
	public int getCurrentPage() {
		return getPageSize() <= 0 ? 1 : (getStartIndex() + getPageSize()) / getPageSize();
	}
	
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 0 ? 0 : pageSize;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
}
