package com.pds.controllers;

import java.text.ParseException;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Korisnik;

@Controller
@RequestMapping(value="auth")
public class LoginController {
	
	@Autowired
	private KorisnikController kc;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login(HttpServletResponse response) throws IOException {
		response.sendRedirect("/pdsWEB/login.jsp");
	}
	
	@RequestMapping(value="registracija", method=RequestMethod.POST)
	public String registrujKorisnika(String ime, String prezime, String username, String sifra, String datumRodjenja, HttpServletRequest request) throws ParseException {
	    Date d = Date.valueOf(datumRodjenja);
		Korisnik k = new Korisnik(d, ime, prezime, username);
	    BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
	    k.setSifra(bcp.encode(sifra));
	    if(kc.registrujKorisnika(k, request))
	    	return "redirect:../login.jsp";
	    else 
	    	return "auth/register";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET) 
	public String logout() {
		return "logout";
	}
	
}
