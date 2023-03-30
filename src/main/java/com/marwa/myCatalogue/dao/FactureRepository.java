package com.marwa.myCatalogue.dao;

import com.marwa.myCatalogue.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
