package com.page.daoImpl;

import java.util.HashMap;
import java.util.Map;

import com.page.dao.PageDao;
import com.page.model.PageInfo;


public class PageDaoImpl implements PageDao{

	@Override
	public int countTotalSize(String selectQuery, Object paramObj) {
		return 0;
	}

	@Override
	public Map selectPage(String selectKey, Map map) {
		Map retMap = new HashMap(2);
		//�Ƿ���Ҫ��ҳ
		PageInfo pageInfo = (PageInfo)map.get(PageInfo.PAGEKEY);
		if(pageInfo == null) {
			//��ѯȫ��, �����������PageInfo.PAGEVALUE��
//			retMap.put(PageInfo.PAGEVALUE, value);
//			return retMap;
		} 
		
		//��ƫ�Ƶķ�����ѯ��ҳ
//		retMap.put(PageInfo.PAGEVALUE, queryforList(selectKey, map, pageInfo.getStartIndex(), pageInfo.getPageSize()));
		
		if(pageInfo.getTotalSize() == 0) {
			//��ѯ�ܼ�¼��
			retMap.put(PageInfo.PAGETOTALSIZE, countTotalSize(selectKey, map));
		}
		
		return retMap;
	}

}
