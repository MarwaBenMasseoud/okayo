package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.FactureRepository;
import com.marwa.myCatalogue.entities.Facture;
import com.marwa.myCatalogue.metier.FactureMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureMetierImpl implements FactureMetier {
    @Autowired
    FactureRepository factureRepository;

    @Override
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> listFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public void deleteFactureById(Long id) {
        factureRepository.deleteById(id);
    }
}
