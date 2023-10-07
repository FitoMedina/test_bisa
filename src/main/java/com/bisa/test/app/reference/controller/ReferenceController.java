package com.bisa.test.app.reference.controller;

import com.bisa.test.app.reference.api.CreateReferenceApi;
import com.bisa.test.usecase.CreateReference;
import com.bisa.test.usecase.DeleteReference;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/reference")
class ReferenceController {
    private final CreateReference createReference;
    private final DeleteReference deleteReference;

    ReferenceController(CreateReference createReference, DeleteReference deleteReference) {
        this.createReference = createReference;
        this.deleteReference = deleteReference;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    String createReference(@RequestBody @Valid CreateReferenceApi createReferenceApi) {
        createReference.invoke(createReferenceApi);
        return "Reference saved successful";
    }

    @DeleteMapping(value = "/{referenceId}", consumes = MediaType.ALL_VALUE)
    String deleteReference(@PathVariable Integer referenceId) {
        deleteReference.invoke(referenceId);
        return "Reference deleted successful";
    }
}
