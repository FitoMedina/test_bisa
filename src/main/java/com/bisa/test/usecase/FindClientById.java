package com.bisa.test.usecase;

import com.bisa.test.data.ClientRepository;
import com.bisa.test.domain.Client;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;


@Component
public class FindClientById {
    private final ClientRepository clientRepository;

    public FindClientById(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client invoke(Integer clientId) {
        var client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw Problem.valueOf(Status.NOT_FOUND, "Client not found for id $clientId");
        }
    }
}
