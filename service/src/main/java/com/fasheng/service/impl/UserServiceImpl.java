package com.fasheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasheng.dao.UserDAO;
import com.fasheng.model.UserDO;
import com.fasheng.service.interfaces.UserService;

@Component("userService")
@Transactional 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userDAO.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserDO record) {
		return userDAO.insert(record);
	}

	@Override
	public UserDO selectByPrimaryKey(Integer id) {
		return userDAO.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(UserDO record) {
		return userDAO.updateByPrimaryKey(record);
	}

}
