package com.mari.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mari.shop.domain.User;
import com.mari.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	private final UserMapper userMapper;

	@Override
	public List<User> listAll() {
		return userMapper.selectAll();
	}

	@Override
	public int deleteUser(Long userId) {
		int result =0;
		result = userMapper.delete(userId);
		return result;	
	}
	
	

}
