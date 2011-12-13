package com.fasheng.service.interfaces;

import com.fasheng.dto.UserDTO;
import com.fasheng.model.UserDO;

public interface UserService {
	int deleteByPrimaryKey(Integer id);
	
	int insert(UserDO record);
	
	UserDTO selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKey(UserDO record);
}
