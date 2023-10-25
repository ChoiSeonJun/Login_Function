package com.cos.securityex01.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cos.securityex01.model.User;
import com.cos.securityex01.model.UserInfoDTO;


@Repository
public class UserDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	//id 중복체크
	public User idCheck(String username) {
		User user = session.selectOne("UserMapper.idCheck", username);
		return user;
		}
	
	public UserInfoDTO selectAll(String username) {
		return session.selectOne("UserMapper.selectAll", username);
	}

}
