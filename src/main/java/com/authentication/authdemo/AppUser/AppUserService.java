package com.authentication.authdemo.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
	
	@Autowired
	private final AppUserRepository appUserRepository;
	private final BCryptPasswordEncoder bcPasswordEncoder;

	public AppUserService(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
		this.bcPasswordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + "user not found"));
	}
	
	public String signUpUser(AppUser appUser) {
		boolean userExists = appUserRepository
				.findByEmail(appUser.getUsername())
				.isPresent();
		if (userExists) {
			throw new IllegalStateException("Email already taken");
		}
		
		String encodedPassword = bcPasswordEncoder.encode(appUser.getPassword());
		
		appUser.setPassword(encodedPassword);
		
		appUserRepository.save(appUser);
		
		return "it works";
	}

}
