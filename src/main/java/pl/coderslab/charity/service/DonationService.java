package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;



    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }


    public Integer countQuantities() {
        Integer sum = donationRepository.countQuantities();
        if (sum==null){
            sum = 0;
        }
        return sum;
    }


    public Integer countDonations(){
        return donationRepository.countDonations();
    }


    public void save(Donation donation) {
        donationRepository.save(donation);
    }
}