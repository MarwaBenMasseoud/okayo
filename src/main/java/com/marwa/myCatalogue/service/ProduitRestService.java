package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Produit;
import com.marwa.myCatalogue.metier.ProduitMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestService {

    @Autowired
    ProduitMetier produitMetier;

    @PostMapping(value = "/produits", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter un produit", description = "Methode permettant d'ajouter un nouveau produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit ajouté avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public Produit saveProduit(@RequestBody Produit produit) {
        return produitMetier.saveProduit(produit);
    }


    @GetMapping(value = "/produits", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des produits", description = "Methode permettant d'avoir la liste des produits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des produits", content = {@Content(mediaType = "application/json")})
    })
    public List<Produit> listProduit() {
        return produitMetier.listProduit();
    }


    @GetMapping(value = "/produits/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche un produit par id", description = "Methode permettant de rechercher un produit par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit trouvé avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucun produit trouvé", content = @Content),
    })
    public Produit getProduit(@PathVariable(name = "id") Long id) {
        return produitMetier.getProduitById(id);
    }

    @PutMapping(value = "/produits/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier un produit par id", description = "Methode permettant de modifier les infos d'un produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Produit introuvable", content = @Content),
    })
    public Produit update(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
        produit.setIdProduit(id);
        return produitMetier.saveProduit(produit);
    }


    @DeleteMapping(value = "/produits/{id}")
    @Operation(summary = "Supprimer un produit par id", description = "Methode permettant de supprimer un produit par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Produit introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        produitMetier.deleteProduitById(id);
    }
}
