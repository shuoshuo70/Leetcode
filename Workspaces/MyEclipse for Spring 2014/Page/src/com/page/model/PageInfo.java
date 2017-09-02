package com.page.model;
import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 构建页面的基本信息
 * 需要传输到ETB端，因此需要序列化
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
	 * 起始行
	 */
	int startIndex;
	/**
	 * 当前页页码
	 */
	int curPageNum;
	/**
	 * 分页数量
	 */
	int pageSize;
	/**
	 * 总记录数
	 */
	int totalSize;
	
	/**
	 * 重置总记录数：将总数置0，dao层重新查询db
	 * @return
	 */
	public void resetTotalSize() {
		totalSize = 0;
	}
	
	/**
	 * 重置分页信息，在重新查询中，重置起始页和总数
	 * @return
	 */
	public void reset() {
		setStartIndex(0);
		setTotalSize(0);
	}
	
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPages() {
		int totalPages = getPageSize() <= 0 ? 1 : (int)Math.ceil(getTotalSize() * 1.0 / getPageSize());
		return totalPages;
	}
	
	/**
	 * 计算当前页是第几页
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
