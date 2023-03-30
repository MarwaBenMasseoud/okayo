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
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private String numeroCommande;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateCommande;

    @ManyToOne
    @JoinColumn(name = "client_id_client")
    private Client client;

    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<LigneCommande> lignesCommande;
}
