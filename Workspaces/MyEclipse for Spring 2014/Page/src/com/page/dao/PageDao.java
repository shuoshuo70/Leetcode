package com.page.dao;

import java.util.Map;

/**
 * 分页查询的数据库操作
 * @author shuoshu
 *
 */
public interface PageDao {
	/**
	 * 获取查询结果的总记录数
	 */
	public abstract int countTotalSize(String selectQuery, Object paramObj);

	/**
	 * 分页查询
	 */
	public abstract Map selectPage(String selectKey, Map map);
}
