package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.LigneCommandeRepository;
import com.marwa.myCatalogue.entities.LigneCommande;
import com.marwa.myCatalogue.metier.LigneCommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeMetierImpl implements LigneCommandeMetier {

    @Autowired
    LigneCommandeRepository LigneCommandeRepository;


    @Override
    public LigneCommande saveLigneCommande(LigneCommande LigneCommande) {
        return LigneCommandeRepository.save(LigneCommande);
    }

    @Override
    public List<LigneCommande> listLigneCommande() {
        return LigneCommandeRepository.findAll();
    }

    @Override
    public LigneCommande getLigneCommandeById(Long id) {
        return LigneCommandeRepository.findById(id).get();
    }

    @Override
    public void deleteLigneCommandeById(Long id) {
        LigneCommandeRepository.deleteById(id);
    }
}
