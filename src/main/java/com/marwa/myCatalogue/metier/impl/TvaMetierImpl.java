package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.ProduitRepository;
import com.marwa.myCatalogue.dao.TvaRepository;
import com.marwa.myCatalogue.entities.Tva;
import com.marwa.myCatalogue.metier.TvaMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvaMetierImpl implements TvaMetier {

    @Autowired
    private TvaRepository tvaRepository;
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Tva saveTva(Tva tva) {
        return tvaRepository.save(tva);
    }

    @Override
    public List<Tva> listTva() {
        return tvaRepository.findAll();
    }

    @Override
    public Tva getTvaById(Long id) {
        return tvaRepository.findById(id).get();
    }

    @Override
    public void deleteTvaById(Long id) {
        tvaRepository.deleteById(id);
    }

}
