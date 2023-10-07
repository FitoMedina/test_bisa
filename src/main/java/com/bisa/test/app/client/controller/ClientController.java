package com.bisa.test.app.client.controller;

import com.bisa.test.app.client.api.ClientApi;
import com.bisa.test.app.client.api.CreateClientApi;
import com.bisa.test.app.client.api.ListClients;
import com.bisa.test.usecase.CreateClient;
import com.bisa.test.usecase.GetClientList;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/client")
class ClientController {
    private final CreateClient createClient;
    private final GetClientList getClientList;

    ClientController(CreateClient createClient, GetClientList getClientList) {
        this.createClient = createClient;
        this.getClientList = getClientList;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ClientApi createClient(@RequestBody @Valid CreateClientApi createClientApi) {
        return createClient.invoke(createClientApi);
    }

    @GetMapping
    List<ListClients> getClient() {
        return getClientList.invoke();
    }
}
