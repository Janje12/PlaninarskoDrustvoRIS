package com.pds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.PlaninarskiDom;
import models.Rezervacija;
import models.Znamenitost;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {
	
	public List<Rezervacija> findAllByVrstaRezervacije(String vrstaRezervacije);
	
	@Query("SELECT count(r) FROM Rezervacija r WHERE r.planinarskidom = ?1")
	public int brojPlaninarskiDom(PlaninarskiDom pd);

	public List<Rezervacija> findByZnamenitost(Znamenitost z);
}
