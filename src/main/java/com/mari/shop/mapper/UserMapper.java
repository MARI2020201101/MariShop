package com.mari.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	//@Select("select count(*) from TBL_USER")
	public int count();
}
