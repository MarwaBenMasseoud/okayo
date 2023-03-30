package com.marwa.myCatalogue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommande;
    private int quantite;

    private Double prixTotal;
    private Double tauxTVA;

    @ManyToOne
    @JoinColumn(name = "commande_id_commande")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id_produit")
    private Produit produit;
}
