package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.create.InstitutionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImplementation implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }
}
