package com.pds.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pds.repositories.PlaninaRepository;
import com.pds.repositories.PlaninarskiDomRepository;
import com.pds.repositories.RezervacijaRepository;

import models.Planina;
import models.PlaninarskiDom;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private PlaninaRepository pr;
	@Autowired
	private RezervacijaRepository rr;
	@Autowired
	private PlaninarskiDomRepository pdr;
	
	@RequestMapping(value="panela", method=RequestMethod.GET)
	public String nadjiPanelu(String naziv, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("stranica", naziv);
		statistikaRezervacija(request, response);
		return "admin/admin";
	}
	
	@RequestMapping(value="statistika", method=RequestMethod.GET)
	public void statistikaRezervacija(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Integer> statistika = new HashMap<String, Integer>();
		for(Planina p : pr.findAll()) {
			List<PlaninarskiDom> lpd = pdr.findByPlanina(p);
			int broj = 0;
			for(PlaninarskiDom pd : lpd)
				broj += rr.brojPlaninarskiDom(pd);
			statistika.put(p.getNaziv(), broj);
		}
		request.getSession().setAttribute("statistika", statistika);
	}
	
}
