package com.fasheng.service.service.interfaces;

import com.fasheng.service.dto.UserDTO;

public interface UserService {
	int deleteByPrimaryKey(Integer id);
	
	UserDTO insert(UserDTO userDTO);
	
	UserDTO selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKey(UserDTO userDTO);
	
	/**
	 * 获取当前userId
	 * @return
	 */
	int getCurrentUserId();
	
	/**
	 * 获取下一个userId
	 * @return
	 */
	int getNextUserId();
}
