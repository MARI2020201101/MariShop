package com.mari.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;


@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	@Test
	public void getTime() {
		System.out.println("-------------getTime-------------");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
}
