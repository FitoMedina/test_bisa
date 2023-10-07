package com.bisa.test.usecase;

import com.bisa.test.app.person.api.CreatePersonApi;
import com.bisa.test.data.PersonRepository;
import com.bisa.test.domain.Person;
import org.springframework.stereotype.Component;


@Component
public class CreatePerson {
    private final PersonRepository personRepository;

    public CreatePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person invoke(CreatePersonApi createPersonApi) {
        Person person = new Person(createPersonApi.getName(), createPersonApi.getSurname1(), createPersonApi.getSurname2(), createPersonApi.getBirthdate(), createPersonApi.getAddress(), createPersonApi.getDni());
        return personRepository.saveAndFlush(person);
    }

}
