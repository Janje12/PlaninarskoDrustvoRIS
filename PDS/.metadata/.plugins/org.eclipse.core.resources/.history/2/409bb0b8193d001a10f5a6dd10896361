package com.pds.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		System.err.println("-------------------------Ucitan korisnik "  + k.getIme());
		UserDetailsImpl userDetails = new UserDetailsImpl(k);
		userDetails.setUsername(k.getUsername());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDetails.setPassword(passwordEncoder.encode(k.getSifra()));
		return userDetails;
	}
	 
}
