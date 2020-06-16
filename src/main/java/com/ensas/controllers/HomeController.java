package com.ensas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensas.dto.AuthentificationRequestDTO;
import com.ensas.dto.AuthentificationResponseDTO;
import com.ensas.entities.MyUserDetails;
import com.ensas.service.JPAUserDetailsService;
import com.ensas.util.JwtUtil;

@RestController
public class HomeController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired 
	private  JPAUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/home")
	public String Home() {
		return("<p>Home<p>");
	}
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthentificationRequestDTO authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
				);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password");
		}
		final MyUserDetails userdetails=(MyUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt =jwtUtil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthentificationResponseDTO(jwt));
	
	
	}
	
}
