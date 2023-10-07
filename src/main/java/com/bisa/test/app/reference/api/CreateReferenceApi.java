package com.bisa.test.app.reference.api;

import jakarta.validation.constraints.NotNull;


public class CreateReferenceApi {

    @NotNull
    Integer clientId;
    Integer referentId;

    public CreateReferenceApi(Integer clientId, Integer referentId) {
        this.clientId = clientId;
        this.referentId = referentId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getReferentId() {
        return referentId;
    }

    public void setReferentId(Integer referentId) {
        this.referentId = referentId;
    }
}
