package com.mari.shop.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mari.shop.domain.User;
import com.mari.shop.exception.UserAlreadyFoundException;
import com.mari.shop.mapper.UserMapper;
import com.mari.shop.model.RegisterModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public void register(RegisterModel registerModel) {
		registerModel.setPassword(passwordEncoder.encode(registerModel.getPassword()));
		userMapper.insert(registerModel);
	}
	public User login(String username, String password) throws Exception{
		User user = new User();
		user= userMapper.selectByUsernameAndPassword(username,passwordEncoder.encode(password));
		return user;
	}
	public void idCheck(String username) throws Exception{
		User user = userMapper.selectByUsername(username);
		//exception 날리기!!!
		if(user!=null) {
			//이미 그 유저네임사용자가 있음
			throw new UserAlreadyFoundException("사용할 수 없는 이름입니다.");
		}
	}
}
