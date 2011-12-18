package com.fasheng.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.service.dao.UserDAO;
import com.fasheng.service.dto.UserDTO;
import com.fasheng.service.helper.UserHelper;
import com.fasheng.service.model.UserDO;
import com.fasheng.service.service.interfaces.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userDAO.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserDTO userDTO) {
	    UserDO userDO = UserHelper.convert2UserDO(userDTO);
		return userDAO.insert(userDO);
	}

	@Override
	public UserDTO selectByPrimaryKey(Integer id) {
		UserDO userDO = userDAO.selectByPrimaryKey(id);
		return UserHelper.convert2UserDTO(userDO);
	}

	@Override
	public int updateByPrimaryKey(UserDTO userDTO) {
	    UserDO userDO = UserHelper.convert2UserDO(userDTO);
		return userDAO.updateByPrimaryKey(userDO);
	}

}
