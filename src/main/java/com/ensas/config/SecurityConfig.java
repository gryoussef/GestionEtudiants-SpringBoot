package com.ensas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ensas.service.JPAUserDetailsService;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	JPAUserDetailsService userDetailService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService);
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	/*http.httpBasic()*/
    	http.authorizeRequests()
    	.antMatchers("/home").hasRole("USER")
    	.antMatchers("/").permitAll()
    	.and().formLogin();
    	
    }
 
}
