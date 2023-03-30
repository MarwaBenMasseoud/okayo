package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.CommandeRepository;
import com.marwa.myCatalogue.entities.Commande;
import com.marwa.myCatalogue.metier.CommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeMetierImpl implements CommandeMetier {

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> listCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);
    }
}
