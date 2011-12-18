package com.fasheng.service.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.service.dto.ProvinceDTO;
import com.fasheng.service.service.interfaces.ProvinceService;

@ContextConfiguration(locations = { "/application-context.xml"})
public class ProvinceServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	public ProvinceService provinceService;
	
	@Test
	public void testGetAllProvinces() {
		List<ProvinceDTO> list = this.provinceService.getAllProvinces();
		System.out.println(list.size());
	}
}
