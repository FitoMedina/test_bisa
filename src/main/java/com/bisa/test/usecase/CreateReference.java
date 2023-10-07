package com.bisa.test.usecase;

import com.bisa.test.app.reference.api.CreateReferenceApi;
import com.bisa.test.data.ClientRepository;
import com.bisa.test.data.ReferenceRepository;
import com.bisa.test.domain.Client;
import com.bisa.test.domain.Reference;
import org.springframework.stereotype.Component;


@Component
public class CreateReference {
    private final ReferenceRepository referenceRepository;
    private final ClientRepository clientRepository;
    private final FindClientById findClientById;

    public CreateReference(ReferenceRepository referenceRepository, ClientRepository clientRepository, FindClientById findClientById) {
        this.referenceRepository = referenceRepository;
        this.clientRepository = clientRepository;
        this.findClientById = findClientById;
    }

    public void invoke(CreateReferenceApi createReferenceApi) {
        var client = findClientById.invoke(createReferenceApi.getClientId());
        Client referent = null;
        if(createReferenceApi.getReferentId() != null){
            referent = findClientById.invoke(createReferenceApi.getReferentId());
        }
        Reference reference = new Reference(client, referent, null);

        reference = referenceRepository.saveAndFlush(reference);
    }
}
