package com.holywar.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.holywar.dao.UserDao;
import com.holywar.model.User;

@Component("userService")
public class UserService {

	private UserDao userDao;

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	public User findUserById(User user) {
		return userDao.getUserById(user);
	}
}
