package com.orange.donateforcause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.donateforcause.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByMobileAndPassword(Long mobile, String password);
}
