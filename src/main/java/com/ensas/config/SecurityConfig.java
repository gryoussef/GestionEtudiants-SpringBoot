package com.ensas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ensas.filters.JwtRequestFilter;
import com.ensas.service.JPAUserDetailsService;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	JPAUserDetailsService userDetailService;
	@Autowired
	JwtRequestFilter jwtFiliter;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService);
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	/*http.httpBasic()*/
    	
    	http.csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/authenticate").permitAll()
    	.antMatchers("/home").hasRole("USER")
    	.anyRequest().authenticated()
    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	http.addFilterBefore(jwtFiliter,UsernamePasswordAuthenticationFilter.class);
    	
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
