package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.LigneCommande;

import java.util.List;

public interface LigneCommandeMetier {

    public LigneCommande saveLigneCommande(LigneCommande LigneCommande);

    public List<LigneCommande> listLigneCommande();

    public LigneCommande getLigneCommandeById(Long id);

    public void deleteLigneCommandeById(Long id);

}
