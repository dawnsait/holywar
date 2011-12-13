package com.fasheng.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasheng.service.interfaces.CityService;
import com.fasheng.service.interfaces.DistrictService;
import com.fasheng.service.interfaces.ProvinceService;

public class DataServiceLocator {
	
	private static ApplicationContext context;;
	
	static {
		context = new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
	}
	
	public static ProvinceService getProvinceService() {
		return (ProvinceService) context.getBean("provinceService");
	}
	
	public static CityService getCityService() {
		return (CityService) context.getBean("cityService");
	}
	
	public static DistrictService getDistrictService() {
		return (DistrictService) context.getBean("districtService");
	}

}
