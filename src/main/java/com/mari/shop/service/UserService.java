package com.mari.shop.service;

import com.mari.shop.model.RegisterModel;


public interface UserService {
	public void register(RegisterModel registerModel);
	public void login(String username, String password);
	public void idCheck(String username)throws Exception;
}
