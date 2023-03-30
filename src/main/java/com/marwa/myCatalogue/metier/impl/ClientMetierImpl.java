package com.marwa.myCatalogue.metier.impl;

import com.marwa.myCatalogue.dao.ClientRepository;
import com.marwa.myCatalogue.entities.Client;
import com.marwa.myCatalogue.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientMetierImpl implements ClientMetier {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

}
