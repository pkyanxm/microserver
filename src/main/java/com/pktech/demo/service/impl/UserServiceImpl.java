package com.pktech.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pktech.demo.dao.UserDao;
import com.pktech.demo.entity.User;
import com.pktech.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.findUserByPhone(phone);
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}
	
	
}
