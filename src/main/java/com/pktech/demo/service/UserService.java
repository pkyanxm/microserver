package com.pktech.demo.service;

import com.pktech.demo.entity.User;

public interface UserService {
	public User findUserByPhone(String phone);
	public int save(User user);
}
