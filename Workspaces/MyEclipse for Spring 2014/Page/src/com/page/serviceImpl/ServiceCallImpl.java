package com.page.serviceImpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.page.dao.PageDao;
import com.page.daoImpl.PageDaoImpl;
import com.page.service.ServiceCall;

@Component("serviceCall")
public class ServiceCallImpl implements ServiceCall{

	PageDao pageDao = new PageDaoImpl();
	
	public ServiceCallImpl(String model) {
		serviceCall = new ServiceCallImpl(model);
	}

	public Map call(String target, Map dataMap) {
//		pageDao
		return null;
	}

	ServiceCall serviceCall; 
	
	public ServiceCall getServiceCall() {
		return serviceCall;
	}

	public void setServiceCall(ServiceCall serviceCall) {
		this.serviceCall = serviceCall;
	}

	public PageDao getPageDao() {
		return pageDao;
	}
	
	@Resource
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

}
