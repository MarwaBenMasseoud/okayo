package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.Tva;

import java.util.List;

public interface TvaMetier {
    public Tva saveTva(Tva tva);

    public List<Tva> listTva();

    public Tva getTvaById(Long id);

    public void deleteTvaById(Long id);

}
