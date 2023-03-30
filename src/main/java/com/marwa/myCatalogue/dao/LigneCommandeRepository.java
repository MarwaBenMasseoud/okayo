package com.marwa.myCatalogue.dao;

import com.marwa.myCatalogue.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
