package com.fasheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.dao.UserDAO;
import com.fasheng.dto.UserDTO;
import com.fasheng.model.UserDO;
import com.fasheng.service.interfaces.UserService;

@Service("userService")
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
	public UserDTO selectByPrimaryKey(Integer id) {
		UserDO userDO = userDAO.selectByPrimaryKey(id);
		UserDTO userDTO = new UserDTO();
		return userDTO;
	}

	@Override
	public int updateByPrimaryKey(UserDO record) {
		return userDAO.updateByPrimaryKey(record);
	}

}
