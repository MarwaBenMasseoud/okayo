package com.marwa.myCatalogue.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateFacturation;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateEcheance;
    private Double totalHt;
    private Double totalTtc;


    @OneToOne
    @JoinColumn(name = "commande_id_commande")
    private Commande commande;

}
