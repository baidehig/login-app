package com.loginapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set your configuration on the auth object
		//create users in memory instead of spring default user
		auth.inMemoryAuthentication()
		.withUser("John Doe")
		.password("Demo@123")
		.roles("USER")
		.and()
		.withUser("John Doe")
		.password("Demo@123")
		.roles("USER","ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//this will return no encoding 
		//apply base64 encoding in real applications
		//this is deprecated
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//this is to match requests to roles
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
}
