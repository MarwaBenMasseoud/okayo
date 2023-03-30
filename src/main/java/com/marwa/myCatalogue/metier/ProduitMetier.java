package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.Produit;

import java.util.List;

public interface ProduitMetier {

    public Produit saveProduit(Produit produit);

    public List<Produit> listProduit();

    public Produit getProduitById(Long id);

    public void deleteProduitById(Long id);

}
