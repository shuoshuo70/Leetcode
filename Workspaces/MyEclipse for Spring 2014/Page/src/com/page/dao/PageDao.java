package com.page.dao;

import java.util.Map;

/**
 * ��ҳ��ѯ�����ݿ����
 * @author shuoshu
 *
 */
public interface PageDao {
	/**
	 * ��ȡ��ѯ������ܼ�¼��
	 */
	public abstract int countTotalSize(String selectQuery, Object paramObj);

	/**
	 * ��ҳ��ѯ
	 */
	public abstract Map selectPage(String selectKey, Map map);
}
