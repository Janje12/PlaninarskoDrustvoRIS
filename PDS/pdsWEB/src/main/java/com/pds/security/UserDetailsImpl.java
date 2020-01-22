package com.pds.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import models.Korisnik;
import models.Uloga;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Korisnik k;

	public UserDetailsImpl() {

	}

	public UserDetailsImpl(Korisnik k) {
		this.k = k;
	}

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>(); 
		authorities.add(new SimpleGrantedAuthority("ROLE_" + k.getUloga().getNaziv()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return k.getSifra();
	}

	@Override
	public String getUsername() {
		return k.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setUsername(String username) {
		k.setUsername(username);
	}

	public void setPassword(String sifra) {
		k.setSifra(sifra);
	}

	public Uloga getUloga() {
		return k.getUloga();
	}

	public void setUloga(Uloga u) {
		k.setUloga(u);
	}

}
