package com.pds.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pds.repositories.KorisnikRepository;
import com.pds.repositories.UlogaRepository;

import models.Korisnik;
import models.Uloga;

@Controller
@RequestMapping(value="Korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikRepository kr;
	@Autowired
	private UlogaRepository ur;
	
	@RequestMapping(value="dodaj", method=RequestMethod.POST)
	public String dodajKorisnika(String ime, String prezime, String username, 
			String sifra, Date datumRodjenja, String idUloga, HttpServletRequest request) {
		Uloga u = ur.findById(Integer.parseInt(idUloga)).get();
		Korisnik k = kr.save(new Korisnik(ime, prezime, username, sifra, datumRodjenja, u));
		String poruka = "Neuspesno dodat korisnik " + ime + " u bazu.";
		if(k != null) {
			poruka = "Uspesno dodat " + ime + " u bazu";
		}
		request.setAttribute("poruka", poruka);
		return "admin/korisnik";
	}
	
	@RequestMapping(value="registruj", method=RequestMethod.POST)
	public boolean registrujKorisnika(Korisnik k, HttpServletRequest request) {
		Korisnik k1 = kr.findByUsername(k.getUsername());
		String poruka = "Vec postoji korisnik sa tim korisnickim imenom pokustaje neko drugo ime!";
		if(k1 == null) {
			poruka = "Hvala na registraciji sacekajte da vas neki od nasih sekretara prihvati!";
			k.setUloga(ur.findById(2).get()); //obican korisnik
			kr.save(k);
			request.setAttribute("poruka", poruka);
			return true;
		}
		request.setAttribute("poruka", poruka);
		return false;
	}
	
	@RequestMapping(value="obrisi", method=RequestMethod.POST)
	public String obrisiKorisnika(String idKorisnik, HttpServletRequest request) {
		String poruka = "Neuspesno obrisan korisnik sa ID-om " + idKorisnik + " iz baze.";
		if(idKorisnik != null) {
			kr.deleteById(Integer.parseInt(idKorisnik));
			poruka = "Uspesno obrisan korisnik sa ID-om " + idKorisnik + " iz baze";
		}
		request.setAttribute("poruka", poruka);
		return "admin/korisnik";
	}
	
	@RequestMapping(value="dodeliUlogu", method=RequestMethod.POST)
	public String dodeliUloguKorisniku(String idKorisnik, String idUloga, HttpServletRequest request) {
		Uloga u = ur.findById(Integer.parseInt(idUloga)).get();
		Korisnik k = kr.findById(Integer.parseInt(idKorisnik)).get();
		String poruka = "Neuspesno dodata uloga korisniku";
		if(k != null && u != null) {
			k.setUloga(u);
			kr.save(k);
			poruka = "Uspesno dodata uloga " + u.getNaziv() + " korisniku " + k.getIme() +
					" u bazu";
		}
		request.setAttribute("poruka", poruka);
		return "admin/korisnik";
	}
	
	@RequestMapping(value="promeniSifru", method=RequestMethod.POST)
	public String promeniSifruKorisniku(String idKorisnik, String sifra, HttpServletRequest request) {
		Korisnik k = kr.findById(Integer.parseInt(idKorisnik)).get();
		String poruka = "Neuspesno promenjena sifra korisniku " + k.getIme() + " u bazi";
		if(k != null) {
			k.setSifra(sifra);
			kr.save(k);
			poruka = "Uspesno promenjena sifra korisniku " + k.getIme() +
					" u bazi";
		}
		request.setAttribute("poruka", poruka);
		return "admin/korisnik";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.GET) 
	public String listaKorisnika(HttpServletRequest request) {
		List<Korisnik> lk = kr.findAll();
		String poruka = "Neuspesno dobavljena lista korisnika.";
		if(lk != null) {
			poruka = "Uspesno dobavljena lista korisnika.";
			request.getSession().setAttribute("korisnici", lk);
		}
		request.setAttribute("poruka", poruka);
		return "admin/korisnik";
	}
	
	@RequestMapping(value="prihvati", method=RequestMethod.GET)
	public String prihvatiKorisnika(String idKorisnika, HttpServletRequest request) {
		Korisnik k = kr.findById(Integer.parseInt(idKorisnika)).get();
		String poruka = "Doslo je do greske!";
		if(k != null) {
			k.setUloga(ur.findById(1).get()); //planinar
			kr.save(k);
			poruka = "Uspesno prihvacen korisnik " + k.getUsername();
			listaKorisnika(request);
		}
		request.setAttribute("poruka", poruka);	
		return "admin/korisnik";
	}
}
