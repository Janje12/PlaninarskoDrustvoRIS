package com.pds.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pds.repositories.IzvestajRepository;
import com.pds.repositories.KorisnikRepository;
import com.pds.repositories.SlikaRepository;
import com.pds.security.UserDetailsImpl;

import models.Izvestaj;
import models.Korisnik;
import models.Slika;

@Controller
@RequestMapping(value="Izvestaj")
public class IzvestajController {

	@Autowired
	private IzvestajRepository ir;
	@Autowired
	private KorisnikRepository kr;
	@Autowired
	private SlikaRepository slr;
	
	@RequestMapping(value="dodaj", method=RequestMethod.POST)
	public void dodajIzvestaj(String naslov, String sadrzaj, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Date datumNastanka = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = ((UserDetailsImpl) auth.getPrincipal()).getUsername();
		Korisnik k = kr.findByUsername(username);
		Izvestaj i = ir.save(new Izvestaj(datumNastanka, naslov, sadrzaj, k));
		String poruka = "Neuspesno dodat izvestaj sa naslovom " + naslov + " u bazu.";
		if(i != null) {
			poruka = "Uspesno dodat izvestaj sa naslovom " + naslov + " u bazu";
		}
		request.setAttribute("poruka", poruka);
		response.sendRedirect("/pdsWEB/index-2.jsp");
	}
	
	@RequestMapping(value="obrisi", method=RequestMethod.POST)
	public String obrisiIzvestaj(String idIzvestaj, HttpServletRequest request) {
		String poruka = "Neuspesno obrisan izvestaj sa ID-om " + idIzvestaj + " iz baze.";
		if(idIzvestaj != null) {
			ir.deleteById(Integer.parseInt(idIzvestaj));
			poruka = "Uspesno obrisan izvestaj sa ID-om " + idIzvestaj + " iz baze";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/izvestaj.jsp";
	}
	
	@RequestMapping(value="promeniSadrzaj", method=RequestMethod.POST)
	public String promeniSadrzajIzvestaja(String idIzvestaj, String sadrzaj, HttpServletRequest request) {
		Izvestaj i = ir.findById(Integer.parseInt(idIzvestaj)).get();
		String poruka = "Neuspesno promenjen sadrzaj izvestaja korisnika " + i.getKorisnik().getUsername() + " u bazi";
		if(i != null) {
			i.setSadrzaj(sadrzaj);;
			ir.save(i);
			poruka = "Uspesno promenjen sadrzaj izvestaja korisnika " + i.getKorisnik().getUsername() + " u bazi";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/izvestaj.jsp";
	}
	
	@RequestMapping(value="promeniNaslov", method=RequestMethod.POST)
	public String promeniNaslovIzvestaja(String idIzvestaj, String naslov, HttpServletRequest request) {
		Izvestaj i = ir.findById(Integer.parseInt(idIzvestaj)).get();
		String poruka = "Neuspesno promenjen naslov izvestaja korisnika " + i.getKorisnik().getUsername() + " u bazi";
		if(i != null) {
			i.setNaslov(naslov);
			ir.save(i);
			poruka = "Uspesno promenjen naslov izvestaja korisnika " + i.getKorisnik().getUsername() + " u bazi";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/izvestaj.jsp";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.POST) 
	public String listaIzvestaja(HttpServletRequest request) {
		List<Izvestaj> li = ir.findAll();
		String poruka = "Neuspesno dobavljena lista izvestaja.";
		if(li != null) {
			poruka = "Uspesno dobavljena lista izvestaja.";
			request.setAttribute("izvestaji", li);
		}
		request.setAttribute("poruka", poruka);
		return "/admin/izvestaj.jsp";
	}
	
	@RequestMapping(value="listaI", method=RequestMethod.GET) 
	public void listaIzvestaja(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Izvestaj> li = ir.findAll();
		List<Slika> lsl = slr.findAll();
		String poruka = "Neuspesno dobavljena lista izvestaja.";
		if(li != null) {
			li.sort((Izvestaj i1, Izvestaj i2) -> i2.getDatumNastanka().compareTo(i1.getDatumNastanka()));
			poruka = "Uspesno dobavljena lista izvestaja.";
			request.getSession().setAttribute("izvestaji", li);
			request.getSession().setAttribute("slike", lsl);
		}
		request.setAttribute("poruka", poruka);
		response.sendRedirect("/pdsWEB/index-2.jsp");
	}
	
}
