package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Commande;
import com.marwa.myCatalogue.metier.CommandeMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeRestService {

    @Autowired
    private CommandeMetier commandeMetier;

    @PostMapping(value = "/commandes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter une commande", description = "Methode permettant d'ajouter une nouvelle commande")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande ajoutée avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public Commande saveCommande(@RequestBody Commande comande) {
        return commandeMetier.saveCommande(comande);
    }


    @GetMapping(value = "/commandes", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des commandes", description = "Methode permettant d'avoir la liste des commandes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des commandes", content = {@Content(mediaType = "application/json")})
    })
    public List<Commande> listCommande() {
        return commandeMetier.listCommande();
    }

    @GetMapping(value = "/commandes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche une commande par id", description = "Methode permettant de rechercher une commande par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande trouvée avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucune Commande trouvée", content = @Content),
    })
    public Commande getCommande(@PathVariable(name = "id") Long id) {
        return commandeMetier.getCommandeById(id);
    }


    @PutMapping(value = "/commandes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier une commande par id", description = "Methode permettant de modifier les infos d'une commande")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Commande introuvable", content = @Content),
    })
    public Commande update(@PathVariable(name = "id") Long id, @RequestBody Commande commande) {
        commande.setIdCommande(id);
        return commandeMetier.saveCommande(commande);
    }


    @DeleteMapping(value = "/commandes/{id}")
    @Operation(summary = "Supprimer une commandes par id", description = "Methode permettant de supprimer une commande par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "commande introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        commandeMetier.deleteCommandeById(id);
    }
}
