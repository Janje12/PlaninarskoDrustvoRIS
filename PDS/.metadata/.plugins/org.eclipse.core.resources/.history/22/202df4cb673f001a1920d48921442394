package com.pds.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pds.controllers.PlaninaController;
import com.pds.repositories.PlaninaRepository;

import models.Planina;

@Controller
public class PlanineBean {
	
	@Autowired
	private PlaninaRepository pr;
	
	private List<Planina> lp;
	
	public PlanineBean() {
		
	}

	public List<Planina> getLp() {
		return lp;
	}

	public void setLp(List<Planina> lp) {
		this.lp = lp;
	}
	
}
