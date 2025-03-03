package com.pds.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pds.repositories.StazaRepository;
import com.pds.repositories.ZnamenitostRepository;

import models.Staza;
import models.Znamenitost;

@Controller
@RequestMapping(value="Znamenitost")
public class ZnamenitostController {

	@Autowired
	private ZnamenitostRepository zr;
	@Autowired
	private StazaRepository sr;
	
	@RequestMapping(value="dodaj", method=RequestMethod.POST)
	public String dodajZnamenitost(String naziv, String opis, String tip, 
			String idStaza, String potrebnaRezervacija, HttpServletRequest request) {
		Staza s = sr.findById(Integer.parseInt(idStaza)).get();
		Znamenitost z = zr.save(new Znamenitost(naziv, opis, potrebnaRezervacija, tip, s));
		String poruka = "Neuspesno dodata znamenitost " + naziv + " u bazu.";
		if(z != null) {
			poruka = "Uspesno dodata znamenitost " + naziv + " u bazu";
		}
		request.setAttribute("poruka", poruka);
	
		return "/admin/znamenitost.jsp";
	}
	
	@RequestMapping(value="obrisi", method=RequestMethod.POST)
	public String obrisiZnamenitost(String idZnamenitost, HttpServletRequest request) {
		String poruka = "Neuspesno obrisana znamenitost sa ID-om " + idZnamenitost + " iz baze.";
		if(idZnamenitost != null) {
			zr.deleteById(Integer.parseInt(idZnamenitost));
			poruka = "Uspesno obrisana znamenitost sa ID-om " + idZnamenitost + " iz baze";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/znamenitost.jsp";
	}
	
	@RequestMapping(value="promeniOpis", method=RequestMethod.POST)
	public String promeniOpisZnamenitosti(String idZnamenitost, String opis, HttpServletRequest request) {
		Znamenitost z = zr.findById(Integer.parseInt(idZnamenitost)).get();
		String poruka = "Neuspesno promenjen opis znamenitosti " + z.getNaziv() + " u bazi";
		if(z != null) {
			z.setOpis(opis);
			zr.save(z);
			poruka = "Uspesno promenjen opis znamenitosti " + z.getNaziv() +
					" u bazi";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/znamenitost.jsp";
	}

	@RequestMapping(value="lista", method=RequestMethod.GET) 
	public String listaZnamenitosti(HttpServletRequest request) {
		List<Znamenitost> lz = zr.findAll();
		String poruka = "Neuspesno dobavljena lista znamenitosti.";
		if(lz != null) {
			poruka = "Uspesno dobavljena lista znamenitosti.";
			request.getSession().setAttribute("znamenitosti", lz);
		}
		request.setAttribute("poruka", poruka);
		return "admin/znamenitost";
	}
	
}
