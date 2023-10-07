package com.bisa.test.usecase;

import com.bisa.test.app.client.api.ClientApi;
import com.bisa.test.app.client.api.CreateClientApi;
import com.bisa.test.app.person.api.PersonApi;
import com.bisa.test.data.ClientRepository;
import com.bisa.test.domain.Client;
import com.bisa.test.domain.ClientStatus;
import org.springframework.stereotype.Component;


@Component
public class CreateClient {
    private final ClientRepository clientRepository;
    private final FindPersonById findPersonById;

    public CreateClient(ClientRepository clientRepository, FindPersonById findPersonById) {
        this.clientRepository = clientRepository;
        this.findPersonById = findPersonById;
    }

    public ClientApi invoke(CreateClientApi createClientApi) {
        var person = findPersonById.invoke(createClientApi.getPersonId());
        Client client = new Client(createClientApi.getEmail(), createClientApi.getPhone(), createClientApi.getOcupation(), ClientStatus.CREATED.name(), person);

        client = clientRepository.saveAndFlush(client);
        return new ClientApi(client.getId(), client.getEmail(), client.getPhone(), client.getOcupation(), client.getStatus(),
                new PersonApi(client.getPerson().getId(), client.getPerson().getName(), client.getPerson().getSurname1(), client.getPerson().getSurname2(), client.getPerson().getBirthdate(), client.getPerson().getAddress(), client.getPerson().getDni()));
    }
}
