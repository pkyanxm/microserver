package com.pktech.demo.web;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pktech.demo.entity.User;
import com.pktech.demo.service.UserService;

@RestController
@RequestMapping("/sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@GetMapping("/login")
	public Map<String, Object> login(@RequestParam String phone, @RequestParam String password){
		Map<String, Object> map  = new HashMap<String, Object>();
//		try {
			User user = userService.findUserByPhone(phone);
			if(user != null ){
				if(!password.equals(user.getPassword())){
					map.put("code", "0001");
					map.put("msg", "密码错误");
				}else {
					map.put("code", "0002");
					map.put("msg", "登录成功");
				}
			} else {
				map.put("code", "0003");
				map.put("msg", "找不到该用户");
			}
//		} catch (Exception e) {
//			map.put("code", "0004");
//			map.put("msg", "登录失败，请重新登陆");
//		}		
		return map;
	}
	
	@CrossOrigin
	@PostMapping("/register")
	public Map<String, Object> register(@RequestBody User user){
		Map<String, Object> map  = new HashMap<String, Object>();
//		try {
			user.setId(UUID.randomUUID().toString());
			User u = userService.findUserByPhone(user.getPhone());
			if(u != null){
				map.put("code", "0001");
				map.put("msg", "用户已存在");
			}else {
				userService.save(user);
				map.put("code", "0000");
				map.put("msg", "注册成功");
			}
//		} catch (Exception e) {
//			map.put("code", "0002");
//			map.put("msg", "注册失败，请重新注册");
//		}
		return map;
	}
}
