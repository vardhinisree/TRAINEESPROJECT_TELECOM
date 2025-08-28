package com.telecom.Wezen.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByMailIgnoreCase(String mail);

	Optional<Users> findById(Long id);

	
	

}
