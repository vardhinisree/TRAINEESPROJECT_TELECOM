package com.telecom.Wezen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	

}
