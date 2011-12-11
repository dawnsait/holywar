package com.fasheng.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.dao.ProvinceDAO;
import com.fasheng.model.ProvinceDO;


@ContextConfiguration(locations = { "/application-context.xml"})
public class ProvinceDAOTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	public ProvinceDAO provinceDAO;
	
	@Test
	public void testGetProvince(){
		ProvinceDO pdo = provinceDAO.selectByPrimaryKey(9);
		String provinceName = pdo.getProvinceName();
		System.out.println(provinceName);
	}
}
