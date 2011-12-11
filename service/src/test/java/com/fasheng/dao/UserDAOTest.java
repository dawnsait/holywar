package com.fasheng.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.model.UserDO;


@ContextConfiguration(locations = { "/application-context.xml"})
public class UserDAOTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	public UserDAO userDAO;
	
	@Test
	public void testInsertUser(){
//		UserDO userDO = new UserDO();
//		userDO.setUserId("2222228");
//		userDO.setUserName("userName8");
//		userDO.setPassword("password");
//		userDO.setRealName("realName");
//		userDO.setNickName("nickName8");
//		userDO.setFirstName("first name");
//		userDO.setLastName("last name");
//		userDO.setEmail("minbing@aaa.com8");
//		userDO.setFirstName("bing");
//		userDAO.insert(userDO);
	}

}