package bahlawan.com.salesmanagementsystem.services;

import bahlawan.com.salesmanagementsystem.dtos.ClientRequest;
import bahlawan.com.salesmanagementsystem.models.Client;
import bahlawan.com.salesmanagementsystem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @Override
    public Client create(ClientRequest request) {
        Client newClient = new Client();
        this.prepare(newClient,request);
        return repository.save(newClient);
    }

    @Override
    public Client update(int clientId, ClientRequest request) {
        Client existingClient = repository.findById(clientId)
                .orElseThrow(()-> new RuntimeException("no clients with this id"));
        this.prepare(existingClient,request);
        return repository.save(existingClient);
    }

    private Client prepare(Client client, ClientRequest request){
        client.setName(request.getName());
        client.setLastName(request.getLastname());
        client.setMobile(request.getMobile());
        return client;
    }
}