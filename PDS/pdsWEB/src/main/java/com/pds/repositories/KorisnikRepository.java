package com.pds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

	public Korisnik findByUsername(String username);

}
