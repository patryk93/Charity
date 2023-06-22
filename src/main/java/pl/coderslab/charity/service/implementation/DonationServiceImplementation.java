package pl.coderslab.charity.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.create.DonationService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationServiceImplementation implements DonationService {
    private final DonationRepository donationRepository;


    @Override
    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public Integer countQuantities() {
        Integer sum = donationRepository.countQuantities();
        if (sum==null){
            sum = 0;
        }
        return sum;
    }

    @Override
    public Integer countDonations(){
        return donationRepository.countDonations();
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }
}