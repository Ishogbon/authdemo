package com.authentication.authdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncrypter {
	
	@Bean
	public BCryptPasswordEncoder bcPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}