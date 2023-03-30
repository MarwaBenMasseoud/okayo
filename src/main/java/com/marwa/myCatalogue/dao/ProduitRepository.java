package com.marwa.myCatalogue.dao;

import com.marwa.myCatalogue.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
