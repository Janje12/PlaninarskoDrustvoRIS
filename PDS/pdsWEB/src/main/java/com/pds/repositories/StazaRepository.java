package com.pds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Planina;
import models.Staza;

public interface StazaRepository extends JpaRepository<Staza, Integer> {

	public List<Staza> findByPlanina(Planina p);

}
