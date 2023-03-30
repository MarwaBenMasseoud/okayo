package com.marwa.myCatalogue.metier;

import com.marwa.myCatalogue.entities.Client;

import java.util.List;

public interface ClientMetier {

    public Client saveClient(Client client);
    public List<Client> listClient();

    public Client getClientById(Long id);

    public void deleteClientById(Long id);

}
