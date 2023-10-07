package com.bisa.test.app.client.api;

import com.bisa.test.app.person.api.PersonApi;
import com.bisa.test.domain.ClientStatus;
import com.bisa.test.domain.Person;


public class ClientApi {
    Long id;
    String email;
    String phone;
    String ocupation;
    String status;
    PersonApi personData;

    public ClientApi(Long id, String email, String phone, String ocupation, String status, PersonApi personData) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.ocupation = ocupation;
        this.status = status;
        this.personData = personData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonApi getPersonData() {
        return personData;
    }

    public void setPersonData(PersonApi personData) {
        this.personData = personData;
    }
}
