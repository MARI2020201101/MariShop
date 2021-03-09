package com.mari.shop.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTests {
	
	@Autowired
	CustomUserDetailsService service;
	
	@Test
	public void loadUserbyUsernameTest() {
		UserDetails user =service.loadUserByUsername("mari");
		log.info(user.toString());
	}
	
	
}
