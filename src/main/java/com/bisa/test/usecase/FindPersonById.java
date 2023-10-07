package com.bisa.test.usecase;

import com.bisa.test.data.PersonRepository;
import com.bisa.test.domain.Person;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;


@Component
public class FindPersonById {
    private final PersonRepository personRepository;

    public FindPersonById(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person invoke(Integer clientId) {
        var person = personRepository.findById(clientId);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw Problem.valueOf(Status.NOT_FOUND, "Person data not found for id $clientId");
        }
    }
}
