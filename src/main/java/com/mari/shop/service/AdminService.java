package com.mari.shop.service;

import java.util.List;

import com.mari.shop.domain.User;

public interface AdminService {
	public List<User> listAll();
	public int deleteUser(Long userId);

}
