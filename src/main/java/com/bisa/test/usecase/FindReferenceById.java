package com.bisa.test.usecase;

import com.bisa.test.data.ReferenceRepository;
import com.bisa.test.domain.Reference;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;


@Component
public class FindReferenceById {
    private final ReferenceRepository referenceRepository;

    public FindReferenceById(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    public Reference invoke(Integer clientId) {
        var reference = referenceRepository.findById(clientId);
        if (reference.isPresent()) {
            return reference.get();
        } else {
            throw Problem.valueOf(Status.NOT_FOUND, "Person data not found for id $clientId");
        }
    }
}
