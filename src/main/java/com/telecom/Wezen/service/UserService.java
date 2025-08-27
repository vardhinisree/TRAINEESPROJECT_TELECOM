package com.telecom.Wezen.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long  id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	
}
