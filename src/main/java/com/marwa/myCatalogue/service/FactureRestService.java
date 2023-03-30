package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Facture;
import com.marwa.myCatalogue.metier.FactureMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactureRestService {

    @Autowired
    private FactureMetier factureMetier;


    @PostMapping(value = "/factures", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter une facture", description = "Methode permettant d'ajouter une nouvelle facture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Facture ajoutée avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public Facture save(@RequestBody Facture facture) {
        return factureMetier.saveFacture(facture);
    }

    @GetMapping(value = "/factures", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des factures", description = "Methode permettant d'avoir la liste des factures")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des factures", content = {@Content(mediaType = "application/json")})
    })
    public List<Facture> listFactures() {
        return factureMetier.listFactures();
    }

    @GetMapping(value = "/factures/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche une facture par id", description = "Methode permettant de rechercher une facture par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Facture trouvée avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucune facture trouvée", content = @Content),
    })
    public Facture getFacture(@PathVariable(name = "id") Long id) {
        return factureMetier.getFactureById(id);
    }


    @PutMapping(value = "/factures/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier une facture par id", description = "Methode permettant de modifier les infos d'une facture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Facture introuvable", content = @Content),
    })
    public Facture update(@PathVariable(name = "id") Long id, @RequestBody Facture facture) {
        facture.setIdFacture(id);
        return factureMetier.saveFacture(facture);
    }


    @DeleteMapping(value = "/factures/{id}")
    @Operation(summary = "Supprimer une facture par id", description = "Methode permettant de supprimer une facture par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Facture introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        factureMetier.deleteFactureById(id);
    }
}
