package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.Client;
import com.marwa.myCatalogue.entities.Commande;

import java.util.List;

public interface CommandeMetier {
    public Commande saveCommande(Commande comande);

    public List<Commande> listCommande();

    public Commande getCommandeById(Long id);

    public void deleteCommandeById(Long id);
}
