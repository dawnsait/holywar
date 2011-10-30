package com.holywar.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.holywar.dao.UserDao;
import com.holywar.model.User;

@Component("userDao") 
public class UserDaoImpl implements UserDao {

	private SqlSessionTemplate sqlSession;
	
	@Resource(name = "sqlSession")
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public User getUserById(User user) {
		return (User)sqlSession.selectOne("com.holywar.model.User.getUser", user); 
	}

}
