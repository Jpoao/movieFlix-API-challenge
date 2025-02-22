package com.devsuperior.movieflix.services;

import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByEmail(username);
	}
	
	public void validateMemberOrVisitor(Long userId) {
		User user = authenticated();
		if(user.getId().equals(userId) && !user.hasRole("ROLE_MEMBER")) {
			throw new ForbiddenException("Access denied!");
		}
	}
}