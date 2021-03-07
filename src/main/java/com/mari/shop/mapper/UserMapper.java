package com.mari.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.User;
import com.mari.shop.model.RegisterModel;

@Mapper
public interface UserMapper {
	//@Select("select count(*) from TBL_USER")
	public int count();
	
	public void insert(RegisterModel registerModel);

	public User selectByUsernameAndPassword(String username, String password);
	
	public Integer selectByUsername(String username);
}
