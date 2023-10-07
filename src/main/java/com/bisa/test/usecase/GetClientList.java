package com.bisa.test.usecase;

import com.bisa.test.app.client.api.ListClients;
import com.bisa.test.data.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetClientList {
    private final ClientRepository clientRepository;

    public GetClientList(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ListClients> invoke() {
        var clients = clientRepository.getOneShotTransactionsByOneShotIdList();
        var id = clients.stream().findFirst().get().getId();
        return clients;
    }
}
