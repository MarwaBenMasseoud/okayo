package com.marwa.myCatalogue.dao;

import com.marwa.myCatalogue.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
