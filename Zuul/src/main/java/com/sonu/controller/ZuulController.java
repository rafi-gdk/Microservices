package com.sonu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonu.security.AuthencateRequest;
import com.sonu.security.JwtTokenUtil;

@RestController
public class ZuulController {

	@Autowired
	JwtTokenUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager; 

	@RequestMapping(value="/hello")
	public String getStart()
	{
		return "Hello Zuul Application";
	}

	@RequestMapping(value="/authenticate")
	public String generateJWT(@RequestBody AuthencateRequest authencateRequest)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authencateRequest.getUserName(),authencateRequest.getPassword()));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return jwtUtil.generateToken(authencateRequest.getUserName());
	}
}
