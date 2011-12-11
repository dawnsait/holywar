package com.fasheng.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.service.interfaces.UserService;

@ContextConfiguration(locations = { "/application-context.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	public UserService userService;
	
	@Test
	public void testUpdateUser() {
//		UserDO userDO = userService.selectByPrimaryKey(5);
//		userDO.setUserId("2222228");
//		userDO.setUserName("userName777");
//		userService.updateByPrimaryKey(userDO);
	}
}
