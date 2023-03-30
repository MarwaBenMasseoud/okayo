package com.marwa.myCatalogue.service;

import com.marwa.myCatalogue.entities.Client;
import com.marwa.myCatalogue.metier.ClientMetier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRestService {

    @Autowired
    private ClientMetier clientMetier;


    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Ajouter un client", description = "Methode permettant d'ajouter un nouveau client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client ajouté avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Le format de donnée n'est pas valide", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur serveur !", content = @Content)
    })
    public Client saveClient(@RequestBody Client client) {
        return clientMetier.saveClient(client);
    }


    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des clients", description = "Methode permettant d'avoir la liste des clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des clients", content = {@Content(mediaType = "application/json")})
    })
    public List<Client> listClient() {
        return clientMetier.listClient();
    }


    @GetMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recherche un client par id", description = "Methode permettant de rechercher un client par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trouvé avec succès", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Aucun client trouvé", content = @Content),
    })
    public Client getClient(@PathVariable(name = "id") Long id) {
        return clientMetier.getClientById(id);
    }


    @PutMapping(value = "/clients/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier un client par id", description = "Methode permettant de modifier les infos d'un client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modification réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content),
    })
    public Client update(@PathVariable(name = "id") Long id, @RequestBody Client client) {
        client.setIdClient(id);
        return clientMetier.saveClient(client);
    }


    @DeleteMapping(value = "/clients/{id}")
    @Operation(summary = "Supprimer un client par id", description = "Methode permettant de supprimer un client par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suppression réussite", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    public void delete(@PathVariable(name = "id") Long id) {
        clientMetier.deleteClientById(id);
    }
}
