package com.jquispeluyo.micrometer.service;


import com.jquispeluyo.micrometer.mongo.IUsuarioRepo;
import com.jquispeluyo.micrometer.mongo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario us = repo.findByNombre(username);


		List<GrantedAuthority> roles = new ArrayList<>();

		us.getRoles().forEach(x -> {
			roles.add(new SimpleGrantedAuthority(x));
		});
		
		UserDetails userDet = new User(us.getNombre(), us.getClave(), roles);
		
		return userDet;
	}

}
