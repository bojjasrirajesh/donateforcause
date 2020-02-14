package com.orange.donateforcause.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
import com.orange.donateforcause.entity.Users;
import com.orange.donateforcause.exception.UserNotFoundException;
import com.orange.donateforcause.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;
	
	
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
		Mockito.when(userRepository.findByMobileAndPassword(userDto.getMobile(), userDto.getPassword())).thenReturn(user);
		LoginResponseDto loginResponseDto2 = userServiceImpl.usersLogin(userDto);
		assertEquals(200, loginResponseDto2.getStatusCode());
	}
	@Test(expected=UserNotFoundException.class)
	public void testUsersLoginException() {
		LoginDto userDto=new LoginDto();
		userDto.setMobile(123456789L);
		userDto.setPassword("12345");
		Users user=new Users();
		user.setUserId(1L);
		LoginDto userDto1=new LoginDto();
		userDto.setMobile(123456L);
		Mockito.when(userRepository.findByMobileAndPassword(userDto.getMobile(), userDto.getPassword())).thenReturn(user);
		LoginResponseDto loginResponseDto2 = userServiceImpl.usersLogin(userDto1);
	}

}
