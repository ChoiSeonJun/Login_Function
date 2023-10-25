package com.cos.securityex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.securityex01.DAO.UserDAO;
import com.cos.securityex01.model.User;
import com.cos.securityex01.model.UserInfoDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;

	@Override
	public User idCheck(String username) {
		User user = dao.idCheck(username);
		return user;
	}

	@Override
	public UserInfoDTO selectAll(String username) {
		return dao.selectAll(username);
	}

}
