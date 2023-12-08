package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfiguration {

	
	@Bean
	public UserDetailsService getuserdetailservice() {
		
		return new UserDetailServiceImpl();
		
	}
	
	@Bean 
	public BCryptPasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider dp = new DaoAuthenticationProvider();
		dp.setUserDetailsService(getuserdetailservice());
		dp.setPasswordEncoder(passwordencoder());
		
		return dp;
		
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
		
		
		
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/user/**").hasRole("USER")
//		.antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
		
	}
	
	
	
	
	
	
	
}
