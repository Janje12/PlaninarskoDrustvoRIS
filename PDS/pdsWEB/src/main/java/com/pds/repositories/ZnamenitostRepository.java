package com.pds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Staza;
import models.Znamenitost;

public interface ZnamenitostRepository extends JpaRepository<Znamenitost, Integer> {

	public List<Znamenitost> findByStaza(Staza s);

}
