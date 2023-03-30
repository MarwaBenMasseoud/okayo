package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Produit;
import com.marwa.myCatalogue.entities.Tva;
import com.marwa.myCatalogue.metier.TvaMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TvaRestService {

    @Autowired
    private TvaMetier tvaMetier;

    @PostMapping(value = "/tva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter un tva", description = "Methode permettant d'ajouter un nouveau tva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tva ajouté avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public Tva saveTva(@RequestBody Tva tva) {
        return tvaMetier.saveTva(tva);
    }


    @GetMapping(value = "/tva", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des tva", description = "Methode permettant d'avoir la liste des tva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des tva", content = {@Content(mediaType = "application/json")})
    })
    public List<Tva> listTva() {
        return tvaMetier.listTva();
    }


    @GetMapping(value = "/tva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche un tva par id", description = "Methode permettant de rechercher un tva par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tva trouvé avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucun tva trouvé", content = @Content),
    })
    public Tva getTva(@PathVariable(name = "id") Long id) {
        return tvaMetier.getTvaById(id);
    }


    @PutMapping(value = "/tva/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier un tva par id", description = "Methode permettant de modifier les infos de la table Tva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Tva introuvable", content = @Content),
    })
    public Tva update(@PathVariable(name = "id") Long id, @RequestBody Tva tva) {
        tva.setIdTva(id);
        return tvaMetier.saveTva(tva);
    }


    @DeleteMapping(value = "/tva/{id}")
    @Operation(summary = "Supprimer un tva par id", description = "Methode permettant de supprimer un tva par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Tva introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        tvaMetier.deleteTvaById(id);
    }

}
