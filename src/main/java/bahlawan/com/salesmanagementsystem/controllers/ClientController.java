package bahlawan.com.salesmanagementsystem.controllers;

import bahlawan.com.salesmanagementsystem.dtos.ClientRequest;
import bahlawan.com.salesmanagementsystem.models.Client;
import bahlawan.com.salesmanagementsystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    public Client create(@RequestBody ClientRequest request){
        return clientService.create(request);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable int id, @RequestBody ClientRequest request){
        return clientService.update(id,request);
    }
}