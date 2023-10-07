package com.bisa.test.app.client.api;

import jakarta.validation.constraints.NotNull;


public class CreateClientApi {

    @NotNull
    String email;
    @NotNull
    String phone;
    @NotNull
    String ocupation;
    @NotNull
    Integer personId;

    public CreateClientApi(String email, String phone, String ocupation, Integer personId) {
        this.email = email;
        this.phone = phone;
        this.ocupation = ocupation;
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
