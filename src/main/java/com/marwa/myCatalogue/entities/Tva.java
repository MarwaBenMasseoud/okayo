package com.marwa.myCatalogue.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Tva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTva;

    private Double tauxTva;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateDebutValidite;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateFinValidite;

    @ManyToOne
    @JoinColumn(name = "produit_id_produit")
    private Produit produit;


}
