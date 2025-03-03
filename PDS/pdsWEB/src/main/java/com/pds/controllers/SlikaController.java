 package com.pds.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pds.repositories.KorisnikRepository;
import com.pds.repositories.SlikaRepository;
import com.pds.security.UserDetailsImpl;

import models.Korisnik;
import models.Slika;

@Controller
@RequestMapping(value="Slika")
public class SlikaController {

	@Autowired
	private SlikaRepository slr;
	@Autowired
	private KorisnikRepository kr;
	
	@RequestMapping(value="dodaj", method=RequestMethod.POST)
	public void dodajSliku(@RequestParam("slika") MultipartFile sl1, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = ((UserDetailsImpl) auth.getPrincipal()).getUsername();
		Korisnik k = kr.findByUsername(username);
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		long vreme = System.currentTimeMillis();
		String putanja = "images/korisnici/" + k.getIdKorisnik() + "_" + formatter.format(d) + "_" + vreme + ".png";
		Slika sl = slr.save(new Slika(d, k, putanja));
		String poruka = "Neuspesno dodata slika sa putanjom " + putanja;
		if(sl != null) {
			byte[] bytes = sl1.getBytes();
			putanja = "C:/Users/Janje/Desktop/PDS/pdsWEB/src/main/webapp/images/korisnici/" + k.getIdKorisnik() + "_" + formatter.format(d)
			+ "_" + vreme + ".png";
			Path path = Paths.get(putanja);
			Files.write(path, bytes);
			poruka = "Uspesno dodata slika u putanju " + putanja;
			
		}
		request.setAttribute("poruka", poruka);
		response.sendRedirect("/pdsWEB/index-2.jsp");
	}
	
	@RequestMapping(value="obrisi", method=RequestMethod.POST)
	public String obrisiPlaninu(String idSlika, HttpServletRequest request) {
		String poruka = "Neuspesno obrisana slika sa ID-om " + idSlika + " iz baze.";
		if(idSlika != null) {
			slr.deleteById(Integer.parseInt(idSlika));
			poruka = "Uspesno obrisana slika sa ID-om " + idSlika + " iz baze";
		}
		request.setAttribute("poruka", poruka);
		return "/admin/planina.jsp";
	}
	
	
}
