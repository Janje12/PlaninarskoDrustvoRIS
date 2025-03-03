package com.pds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Planina;
import models.PlaninarskiDom;

public interface PlaninarskiDomRepository extends JpaRepository<PlaninarskiDom, Integer> {
	
	public List<PlaninarskiDom> findByPlanina(Planina p);
}
