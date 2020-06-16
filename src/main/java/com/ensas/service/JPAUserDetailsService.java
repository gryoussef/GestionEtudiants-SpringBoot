package com.ensas.service;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;

import com.ensas.dao.UserRepository;
import com.ensas.entities.MyUserDetails;
import com.ensas.entities.User;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JPAUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		System.out.println(user.toString());
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		return user.map(MyUserDetails::new).get();
		
	}

/*	public UserDetails findUserById(Integer id) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(id);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + id));
		return user.map(MyUserDetails::new).get();
	}

	public UserDetails getLoggedInUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails;
	}*/
}