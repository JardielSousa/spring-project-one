package com.jas.projectone.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfigurerCustom extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests ->
			authorizeRequests
			.antMatchers("/css/**").permitAll()
			.antMatchers(HttpMethod.GET, "/user/register").permitAll()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.anyRequest().authenticated()
		).formLogin(formLogin -> 
			formLogin.loginPage("/login").permitAll()
		)
		.logout().permitAll()
		;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
