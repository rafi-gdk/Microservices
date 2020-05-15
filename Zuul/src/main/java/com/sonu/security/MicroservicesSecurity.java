package com.sonu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sonu.user.MyUserDetailsService;

@EnableWebSecurity
public class MicroservicesSecurity extends WebSecurityConfigurerAdapter
{
	@Autowired
	MyUserDetailsService myUserDetailsService;	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().//disable cross access or forgery
		authorizeRequests().antMatchers("/authenticate").permitAll().//removing authentication from security
		anyRequest().authenticated();//any request authenticated
	}
}
