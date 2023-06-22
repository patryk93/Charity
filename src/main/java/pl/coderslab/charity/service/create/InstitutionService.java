package pl.coderslab.charity.service.create;

import pl.coderslab.charity.model.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> findAll();

    Optional<Institution> findById(Long id);
}