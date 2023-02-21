package com.authentication.authdemo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.authentication.authdemo.AppUser.AppUser;
import com.authentication.authdemo.AppUser.AppUserRepository;

@RestController
public class AuthController {
	
	@Autowired
    private AppUserRepository appUserRepository;
	
	@RequestMapping(path = "/register", method = RequestMethod.GET, produces = "text/html")
    public String register(){
    	return "<!DOCTYPE html>\r\n"
    			+ "<html xmlns:th=\"https://www.thymeleaf.org\">\r\n"
    			+ "	<head>\r\n"
    			+ "		<meta charset = \"ISO-8859-1\">\r\n"
    			+ "		<title>AppUser Registration Page</title>\r\n"
    			+ "		<style>\r\n"
    			+ "			h1 {\r\n"
    			+ "				color: lightgreen;\r\n"
    			+ "				text-decoration: underline;\r\n"
    			+ "			}\r\n"
    			+ "			form {\r\n"
    			+ "				width: 50%;\r\n"
    			+ "				margin: 0 auto;\r\n"
    			+ "				margin-top: 5%;\r\n"
    			+ "				box-shadow: 1px 1px 4px 2px #ddd;\r\n"
    			+ "				padding: 2%;\r\n"
    			+ "			}\r\n"
    			+ "			label, input {\r\n"
    			+ "				display: block;\r\n"
    			+ "				width: 100%;\r\n"
    			+ "			}\r\n"
    			+ "			input {\r\n"
    			+ "				border: none;\r\n"
    			+ "				outline: none;\r\n"
    			+ "				border-bottom: 2px solid green;\r\n"
    			+ "			}\r\n"
    			+ "			label {\r\n"
    			+ "				margin-top:4%;\r\n"
    			+ "			}\r\n"
    			+ "			button {\r\n"
    			+ "				margin-left: 75%;\r\n"
    			+ "				margin-top: 6%;\r\n"
    			+ "				background: lightgreen;\r\n"
    			+ "				color:white;\r\n"
    			+ "				width: 20%;\r\n"
    			+ "				border: none;\r\n"
    			+ "				padding: 1%;\r\n"
    			+ "				cursor: pointer\r\n"
    			+ "			}\r\n"
    			+ "		</style>\r\n"
    			+ "	</head>\r\n"
    			+ "	<body>\r\n"
    			+ "		<h1>Register An Account</h1>\r\n"
    			+ "		\r\n"
    			+ "		<form action=\"api/v1/registration\" method=\"post\">\r\n"
    			+ "			<label for = \"firstName\">First Name</label>\r\n"
    			+ "			<input type = \"text\" name=\"firstName\" >\r\n"
    			+ "			\r\n"
    			+ "			<label for = \"lastName\">Last Name</label>\r\n"
    			+ "			<input type = \"text\" name=\"lastName\" >\r\n"
    			+ "			\r\n"
    			+ "			<label for = \"email\">Email</label>\r\n"
    			+ "			<input type = \"email\" name=\"email\" >\r\n"
    			+ "			\r\n"
    			+ "			<label for = \"role\">Role</label>\r\n"
    			+ "			<select name = \"role\">\r\n"
    			+ "				<option>USER</option>\r\n"
    			+ "				<option>ADMIN</option>\r\n"
    			+ "				<option>DRIVER</option>\r\n"
    			+ "				<option>SUPERVISOR</option>\r\n"
    			+ "			</select>\r\n"
    			+ "			\r\n"
    			+ "			<label for = \"password\">Password</label>\r\n"
    			+ "			<input type = \"password\" name=\"password\" >\r\n"
    			+ "			\r\n"
    			+ "			<button type=\"submit\">Submit</button>\r\n"
    			+ "		</form>\r\n"
    			+ "	</body>\r\n"
    			+ "</html>";
    }
	@GetMapping("/dashboard")
    public String showDashboard(Authentication authentication, Model model) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        // Use the appUser object to retrieve any additional user information or perform custom logic
        model.addAttribute("appUser", appUser);
        System.out.println(appUser.getFirstName());
		return "<!DOCTYPE html>\r\n"
				+ "<html xmlns:th=\"https://www.thymeleaf.org\">\r\n"
				+ "	<head>\r\n"
				+ "		<meta charset = \"ISO-8859-1\">\r\n"
				+ "		<title>AppUser Profile Panel</title>\r\n"
				+ "		<style>\r\n"
				+ "			h1 {\r\n"
				+ "				color: lightgreen;\r\n"
				+ "				text-decoration: underline;\r\n"
				+ "			}\r\n"
				+ "			#main-div {\r\n"
				+ "				width: 50%;\r\n"
				+ "				margin: 0 auto;\r\n"
				+ "				margin-top: 5%;\r\n"
				+ "				box-shadow: 1px 1px 4px 2px #ddd;\r\n"
				+ "				padding: 2%;\r\n"
				+ "			}\r\n"
				+ "			#main-div > div {\r\n"
				+ "				margin-top: 6%;\r\n"
				+ "				margin-bottom: 6%;\r\n"
				+ "				background: green;\r\n"
				+ "				padding: 1%;\r\n"
				+ "				color: white;\r\n"
				+ "			}\r\n"
				+ "			.value {\r\n"
				+ "				float: right;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "		</style>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "		<h1>Profile Panel</h1>\r\n"
				+ "		\r\n"
				+ "		<div id=\"main-div\">\r\n"
				+ "			<div>\r\n"
				+ "				<span class = \"title\"><span>First Name:</span>\r\n"
				+ "				<span class = \"value\"><span>"+appUser.getFirstName()+"</span>\r\n"
				+ "			</div>\r\n"
				+ "			\r\n"
				+ "			\r\n"
				+ "			<div>\r\n"
				+ "				<span class = \"title\">Last Name:</span>\r\n"
				+ "				<span class = \"value\">"+appUser.getLastName()+"</span>\r\n"
				+ "			</div>\r\n"
				+ "			\r\n"
				+ "			<div>\r\n"
				+ "				<span class = \"title\"><span>Email: </span>\r\n"
				+ "				<span class = \"value\"><span>"+appUser.getUsername()+"</span>\r\n"
				+ "			</div>\r\n"
				+ "			\r\n"
				+ "			<div>\r\n"
				+ "				<span class = \"title\"><span>Role: </span>\r\n"
				+ "				<span class = \"value\"><span>"+appUser.getAppUserRole()+"</span>\r\n"
				+ "			</div>\r\n"
				+ "			\r\n"
				+ "		</div>\r\n"
				+ "	</body>\r\n"
				+ "</html>";
	}
}
