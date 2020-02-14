package com.orange.donateforcause.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private Long mobile;
	private String email;
	private String password;
	
	public Long getUserId() {
		return userId;
	}
}
