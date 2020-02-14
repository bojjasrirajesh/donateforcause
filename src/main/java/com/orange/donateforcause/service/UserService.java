package com.orange.donateforcause.service;
import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
public interface UserService {
	 LoginResponseDto usersLogin(LoginDto userDto); 
}
