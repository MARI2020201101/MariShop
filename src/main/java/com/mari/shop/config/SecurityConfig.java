package com.mari.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.mari.shop.aop.CustomAccessDeniedHandler;
import com.mari.shop.domain.Role;
import com.mari.shop.domain.User;
import com.mari.shop.mapper.UserMapper;
import com.mari.shop.model.RegisterModel;
import com.mari.shop.security.CustomUserDetailsService;
import com.mari.shop.service.UserService;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/user/**").hasAuthority("USER")
			.antMatchers("/**").permitAll()
			
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login?error=true")
		
			.and()
			.exceptionHandling().accessDeniedHandler(accessDenied())
			
			.and()
			.logout()
			.logoutUrl("/logout").invalidateHttpSession(true);

	}
	@Bean
	public AccessDeniedHandler accessDenied() {
		return new CustomAccessDeniedHandler();
	}
	@Bean
	public PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService(userMapper);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncode());
	}
	

}
