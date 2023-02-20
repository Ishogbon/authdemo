package com.authentication.authdemo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.authdemo.AppUser.AppUser;
import com.authentication.authdemo.AppUser.AppUserRole;
import com.authentication.authdemo.AppUser.AppUserService;

@Service
public class RegistrationService {
	
	/**
	 * @param appUserService
	 */
	
	public RegistrationService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}
	@Autowired
	private final AppUserService appUserService;
	public String register(RegistrationRequest request) {
		return appUserService.signUpUser(
				new AppUser (
						request.getFirstName(),
						request.getLastName(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER)
				);
				
	}
}
