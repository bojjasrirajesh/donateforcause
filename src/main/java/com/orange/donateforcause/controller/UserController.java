package com.orange.donateforcause.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
import com.orange.donateforcause.service.UserService;
import com.orange.donateforcause.util.DonateUtil;

/**
 * @author Rajesh
 * 
 *         This class is used for to check the login function. if success it
 *         will return success else it will return user invalid
 * 
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * This method is used to login the account by using mobile and password
	 * 
	 * @param loginDto
	 * @return LoginResponseDto
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDto> usersLogin(@RequestBody LoginDto loginDto) {
		LOGGER.debug(DonateUtil.LOGIN_METHOD);
		LoginResponseDto loginResponseDto = userService.usersLogin(loginDto);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}
}