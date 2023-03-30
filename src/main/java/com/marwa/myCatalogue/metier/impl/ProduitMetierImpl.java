package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.ProduitRepository;
import com.marwa.myCatalogue.entities.Produit;
import com.marwa.myCatalogue.metier.ProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitMetierImpl implements ProduitMetier {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> listProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
}
