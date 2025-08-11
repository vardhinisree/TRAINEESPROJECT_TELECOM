package com.telecom.Wezen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
