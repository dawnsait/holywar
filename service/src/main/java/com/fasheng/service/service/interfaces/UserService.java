package com.fasheng.service.service.interfaces;

import com.fasheng.service.dto.UserDTO;

public interface UserService {
	int deleteByPrimaryKey(Integer id);
	
	int insert(UserDTO userDTO);
	
	UserDTO selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKey(UserDTO userDTO);
}
