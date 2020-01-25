package com.pds.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@RequestMapping(value="panela", method=RequestMethod.GET)
	public String nadjiPanelu(String naziv, HttpServletRequest request) {
		request.setAttribute("stranica", naziv);
		return "admin/admin";
	}
	
}
