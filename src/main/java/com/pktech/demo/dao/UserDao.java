package com.pktech.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pktech.demo.entity.User;

@Mapper
public interface UserDao {
	User findUserByPhone(@Param("phone") String phone);
	int save(User user);
}
