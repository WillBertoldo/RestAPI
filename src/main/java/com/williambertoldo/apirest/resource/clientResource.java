package com.williambertoldo.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williambertoldo.apirest.entity.Client;
import com.williambertoldo.apirest.repository.clientRepository;

@RestController
@RequestMapping(value="/api")
public class clientResource {

    @Autowired
    clientRepository clientRepository;

    @GetMapping("/client/all")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable(value="id") long id){
        return clientRepository.findById(id);
    }

    @GetMapping("/clientName")
    public List<Client> getClientByName(String name){
        List<Client> client = clientRepository.findByNameLike(name);
        return client;
    }

    @PostMapping("/client")
    public Client saveClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/client")
    public void deleteClient(@RequestBody Client client){
        clientRepository.delete(client);
    }

    @PutMapping("/client")
    public Client updateClient(@RequestBody Client client){
        return clientRepository.save(client);
    }
}
