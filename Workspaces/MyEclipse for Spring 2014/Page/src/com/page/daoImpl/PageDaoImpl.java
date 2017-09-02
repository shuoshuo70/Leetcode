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
		//是否需要分页
		PageInfo pageInfo = (PageInfo)map.get(PageInfo.PAGEKEY);
		if(pageInfo == null) {
			//查询全部, 并将结果放在PageInfo.PAGEVALUE中
//			retMap.put(PageInfo.PAGEVALUE, value);
//			return retMap;
		} 
		
		//用偏移的方法查询分页
//		retMap.put(PageInfo.PAGEVALUE, queryforList(selectKey, map, pageInfo.getStartIndex(), pageInfo.getPageSize()));
		
		if(pageInfo.getTotalSize() == 0) {
			//查询总记录数
			retMap.put(PageInfo.PAGETOTALSIZE, countTotalSize(selectKey, map));
		}
		
		return retMap;
	}

}
