package com.bisa.test.usecase;

import com.bisa.test.data.ReferenceRepository;
import org.springframework.stereotype.Component;


@Component
public class DeleteReference {
    private final ReferenceRepository referenceRepository;
    private final FindReferenceById findReferenceById;

    public DeleteReference(ReferenceRepository referenceRepository, FindReferenceById findReferenceById) {
        this.referenceRepository = referenceRepository;
        this.findReferenceById = findReferenceById;
    }

    public void invoke(Integer referenceId) {
        var reference = findReferenceById.invoke(referenceId);
        referenceRepository.delete(reference);
    }
}
