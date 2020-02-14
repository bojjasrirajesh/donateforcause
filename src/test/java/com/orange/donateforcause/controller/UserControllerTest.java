package com.orange.donateforcause.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
import com.orange.donateforcause.entity.Users;
import com.orange.donateforcause.exception.UserNotFoundException;
import com.orange.donateforcause.repository.UserRepository;
import com.orange.donateforcause.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;
	
	
	@Test
	public void testUsersLogin() {
		LoginDto userDto=new LoginDto();
		userDto.setMobile(123456789L);
		userDto.setPassword("12345");
		Users user=new Users();
		user.setMobile(userDto.getMobile());
		user.setUserId(1L);
		LoginResponseDto loginResponseDto=new LoginResponseDto();
		loginResponseDto.setMessage("success");
		loginResponseDto.setStatusCode(200);
		Mockito.when(userService.usersLogin(userDto)).thenReturn(loginResponseDto);
		ResponseEntity<LoginResponseDto> loginResponseDto2 = userController.usersLogin(userDto);
		assertEquals(200, loginResponseDto2.getBody().getStatusCode());
	}

}
