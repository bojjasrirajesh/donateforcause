package com.orange.donateforcause.service;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
import com.orange.donateforcause.entity.Users;
import com.orange.donateforcause.exception.UserNotFoundException;
import com.orange.donateforcause.repository.UserRepository;
import com.orange.donateforcause.util.DonateUtil;
/**
 *   This class used to check login weather the user is patient or doctor
*/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		LoginResponseDto responseDto = new LoginResponseDto();
		Users user = userRepository.findByMobileAndPassword(userDto.getMobile(), userDto.getPassword());
		if (!Objects.isNull(user)) {
			responseDto.setMessage(DonateUtil.SUCCESS);
			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setUserId(user.getUserId());
		} else {
			throw new UserNotFoundException(DonateUtil.INVALID_USER);
		}
		return responseDto;
	}
}
