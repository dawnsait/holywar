package com.fasheng.service.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.service.dao.ProvinceDAO;
import com.fasheng.service.model.ProvinceDO;


@ContextConfiguration(locations = { "/application-context.xml"})
public class ProvinceDAOTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	public ProvinceDAO provinceDAO;
	
	@Test
	public void testGetProvince(){
		ProvinceDO pdo = provinceDAO.selectByPrimaryKey(11);
		String provinceName = pdo.getProvinceName();
		System.out.println(provinceName);
	}
	
	@Test
	public void testSelectAllProvinces() {
		List<ProvinceDO> list = provinceDAO.selectAllProvinces();
		for(ProvinceDO pdo : list) {
			System.out.println(pdo.getId());
			System.out.println(pdo.getProvinceName());
		}
	}
}
