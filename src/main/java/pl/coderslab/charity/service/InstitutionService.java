package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;


    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }


    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }
}
