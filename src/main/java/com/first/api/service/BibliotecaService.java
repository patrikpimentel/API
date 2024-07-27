package com.first.api.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.first.api.entity.model.*;
import com.first.api.entity.repository.UserRepository;

@Service
public class BibliotecaService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
	if(userRepository.existsByeMail(user.geteMail())) {
	    throw new IllegalArgumentException("E-mail is already registered, "
	    	+ "try again with another one.");
	}
	return userRepository.save(user);
    }
    
    @Transactional
    public User findByUserID(Long id) {
	return userRepository.findById(id).
		orElseThrow(NoSuchElementException::new);	
    }
    
    @Transactional
    public List<User> findAllUser() {
	return userRepository.findAll();
    }
    
    
    
}
