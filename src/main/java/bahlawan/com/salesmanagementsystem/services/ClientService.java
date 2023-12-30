package bahlawan.com.salesmanagementsystem.services;

import bahlawan.com.salesmanagementsystem.dtos.ClientRequest;
import bahlawan.com.salesmanagementsystem.models.Client;


import java.util.List;

public interface ClientService {

    List<Client>getAllClients();

    Client create(ClientRequest request);

    Client update(int clientId, ClientRequest request);
}
