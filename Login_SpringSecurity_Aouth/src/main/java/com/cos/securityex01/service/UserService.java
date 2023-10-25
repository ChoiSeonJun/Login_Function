package com.cos.securityex01.service;

import com.cos.securityex01.model.User;
import com.cos.securityex01.model.UserInfoDTO;


public interface UserService {
	
	public User idCheck(String username);
	public UserInfoDTO selectAll(String username);

}
