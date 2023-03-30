package com.marwa.myCatalogue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String designation;
    private Double prix;


    @OneToMany(mappedBy ="produit", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<LigneCommande> lignesCommande;

    @OneToMany(mappedBy ="produit", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Tva> listTva;
}
