package com.fasheng.service.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasheng.service.service.interfaces.CityService;
import com.fasheng.service.service.interfaces.DistrictService;
import com.fasheng.service.service.interfaces.PartnerUserService;
import com.fasheng.service.service.interfaces.ProvinceService;
import com.fasheng.service.service.interfaces.UserService;

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

    public static UserService getUserService() {
        return (UserService) context.getBean("userService");
    }
    
	public static PartnerUserService getPartnerUserService() {
        return (PartnerUserService) context.getBean("partnerUserService");
    }

}
