package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Client;
import com.marwa.myCatalogue.entities.LigneCommande;
import com.marwa.myCatalogue.metier.LigneCommandeMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneCommandeRestService {

    @Autowired
    LigneCommandeMetier ligneCommandeMetier;

    @PostMapping(value = "/LigneCommandes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter une ligne de Commandes", description = "Methode permettant d'ajouter une nouvelle ligne de Commandes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de Commande ajoutéE avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public LigneCommande saveLigneCommande(@RequestBody LigneCommande LigneCommande) {
        return ligneCommandeMetier.saveLigneCommande(LigneCommande);
    }


    @GetMapping(value = "/LigneCommandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des ligne de commandes", description = "Methode permettant d'avoir la liste des ligne de Commandes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des ligne de Commandes", content = {@Content(mediaType = "application/json")})
    })
    public List<LigneCommande> listLigneCommande() {
        return ligneCommandeMetier.listLigneCommande();
    }

    @GetMapping(value = "/LigneCommandes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche une ligne de commande par id", description = "Methode permettant de rechercher une ligne de commande par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ligne de commande trouvée avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucune ligne de commande trouvée", content = @Content),
    })
    public LigneCommande getLigneCommande(@PathVariable(name = "id") Long id) {
        return ligneCommandeMetier.getLigneCommandeById(id);
    }


    @PutMapping(value = "/LigneCommandes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier une ligne de commande par id", description = "Methode permettant de modifier les infos d'une ligne de commande ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Ligne de commande  introuvable", content = @Content),
    })
    public LigneCommande update(@PathVariable(name = "id") Long id, @RequestBody LigneCommande ligneCommande) {
        ligneCommande.setIdLigneCommande(id);
        return ligneCommandeMetier.saveLigneCommande(ligneCommande);
    }


    @DeleteMapping(value = "/LigneCommandes/{id}")
    @Operation(summary = "Supprimer une ligne de commande par id", description = "Methode permettant de supprimer une ligne de commande par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Ligne de commande  introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        ligneCommandeMetier.deleteLigneCommandeById(id);
    }
}
