package pl.coderslab.charity.service.create;

import pl.coderslab.charity.model.Donation;

import java.util.Optional;

public interface DonationService {

    Optional<Donation> findById(Long id);

    Integer countQuantities();

    Integer countDonations();

    void save(Donation donation);
}