package com.mari.shop.service;

import com.mari.shop.domain.User;
import com.mari.shop.model.RegisterModel;


public interface UserService {
	public void register(RegisterModel registerModel);
	public User login(String username, String password) throws Exception;
	public User idCheck(String username)throws Exception;
}
