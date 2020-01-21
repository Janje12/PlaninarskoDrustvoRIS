package com.pds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Integer> {

}
