package com.pds.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pds.repositories.KorisnikRepository;

import models.Korisnik;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private KorisnikRepository kr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Korisnik k = kr.findByUsername(username);
		UserDetailsImpl userDetails = new UserDetailsImpl(k);
		userDetails.setUsername(k.getUsername());
		userDetails.setPassword(k.getSifra());
		return userDetails;
	}
	 
}
