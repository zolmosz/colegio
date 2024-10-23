package com.uan.colegio.service.impl;

//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.uan.colegio.security.SecurityUser;
import com.uan.colegio.service.UserService;

//@Service
//public class SecurityUserDetailsService implements UserDetailsService {
//
//	private final UserService userService;
//
//	public SecurityUserDetailsService(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		var optUser = this.userService.findByUsername(username);
//		
//		if (optUser.isPresent()) {
//			return new SecurityUser(optUser.get());
//		}
//
//		throw new UsernameNotFoundException("Usuario no encontrado " + username);
//	}
//
//}
