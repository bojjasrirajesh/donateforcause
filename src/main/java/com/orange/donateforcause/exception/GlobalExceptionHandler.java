package com.orange.donateforcause.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orange.donateforcause.dto.ResponseDto;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> userNotFoundException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Invalid User");
		responseDto.setStatusCode(201);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}
	
	

	
	
}