package com.mari.shop.security;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mari.shop.domain.User;
import com.mari.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Service
@Log
public class CustomUserDetailsService implements UserDetailsService{

	private final UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("=============================loadUserbyUsername======================");
		User user = userMapper.selectByUsername(username);
		return user==null? null:new CustomUserDetails(user);
		
	}

}
