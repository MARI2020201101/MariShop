package com.mari.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void countTest() throws Exception {
		int result = userMapper.count();
		System.out.println(result);
	}

}
