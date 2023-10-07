package com.bisa.test.app.person.controller;

import com.bisa.test.app.person.api.CreatePersonApi;
import com.bisa.test.domain.Person;
import com.bisa.test.usecase.CreatePerson;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/person")
class PersonController {
    private final CreatePerson createPerson;

    PersonController(CreatePerson createPerson) {
        this.createPerson = createPerson;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Person createPerson(@RequestBody @Valid CreatePersonApi createPersonApi) {
        return createPerson.invoke(createPersonApi);
    }
}
