package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.Facture;

import java.util.List;

public interface FactureMetier {
    public Facture saveFacture(Facture facture);

    public List<Facture> listFactures();

    public Facture getFactureById(Long id);

    public void deleteFactureById(Long id);
}
