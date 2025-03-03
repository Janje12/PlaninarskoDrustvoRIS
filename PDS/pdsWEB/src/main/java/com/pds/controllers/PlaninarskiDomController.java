package com.pds.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pds.repositories.PlaninaRepository;
import com.pds.repositories.PlaninarskiDomRepository;

import models.Planina;
import models.PlaninarskiDom;


@Controller
@RequestMapping(value="PlaninarskiDom")
public class PlaninarskiDomController {

	@Autowired
	private PlaninarskiDomRepository pdr;
	@Autowired
	private PlaninaRepository pr;

	@RequestMapping(value="dodaj", method=RequestMethod.POST)
	public String dodajPlaninarskiDom(String adresa, String geolokacija, String naziv, String opis,
			String idPlanina, HttpServletRequest request) {
		Planina p = pr.findById(Integer.parseInt(idPlanina)).get();
		PlaninarskiDom pd = pdr.save(new PlaninarskiDom(geolokacija, naziv, opis, p));
		String poruka = "Neuspesno dodata planinarski dom " + naziv + " u bazu.";
		if(pd != null) {
			poruka = "Uspesno dodat planinarski dom " + naziv + " u bazu";
		}
		request.setAttribute("poruka", poruka);
	
		return "/admin/planinarskidom.jsp";
	}
	
	@RequestMapping(value="obrisi", method=RequestMethod.POST)
	public String obrisiPlaninarskiDom(String idPLaninarskiDom, HttpServletRequest request) {
		String poruka = "Neuspesno obrisana planinarski dom sa ID-om " + idPLaninarskiDom + " iz baze.";
		if(idPLaninarskiDom != null) {
			pr.deleteById(Integer.parseInt(idPLaninarskiDom));
			poruka = "Uspesno obrisana planinarski dom sa ID-om " + idPLaninarskiDom + " iz baze";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/planinarskidom.jsp";
	}
	
	@RequestMapping(value="promeniOpis", method=RequestMethod.POST)
	public String promeniOpisPlaninarskomDomu(String idPlaninarskiDom, String opis, HttpServletRequest request) {
		PlaninarskiDom pd = pdr.findById(Integer.parseInt(idPlaninarskiDom)).get();
		String poruka = "Neuspesno promenjen opis planinarskog doma " + pd.getNaziv() + " u bazi";
		if(pd != null) {
			pd.setOpis(opis);
			pdr.save(pd);
			poruka = "Uspesno promenjen opis planinarskog doma " + pd.getNaziv() +
					" u bazi";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/planinarskidom.jsp";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.POST) 
	public String listaPlaninarskihDomova(HttpServletRequest request) {
		List<PlaninarskiDom> lpd = pdr.findAll();
		String poruka = "Neuspesno dobavljena lista planinarskih domova.";
		if(lpd != null) {
			poruka = "Uspesno dobavljena lista planinarskih domova.";
			request.setAttribute("planinarskidomovi", lpd);
		}
		request.setAttribute("poruka", poruka);
		return "/admin/planinarskidom.jsp";
	}
	
	
	@RequestMapping(value="listaPD", method=RequestMethod.GET) 
	public void listaPlaninarskihDomova(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<PlaninarskiDom> lpd = pdr.findAll();
		String poruka = "Neuspesno dobavljena lista planinarskih domova.";
		if(lpd != null) {
			poruka = "Uspesno dobavljena lista planinarskih domova.";
			request.getSession().setAttribute("planinarskidomovi", lpd);
		}
		request.setAttribute("poruka", poruka);
		response.sendRedirect("/pdsWEB/index-3.jsp");
	}
}
