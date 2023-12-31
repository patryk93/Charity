package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("select coalesce(sum(d.quantity), 0) from Donation d")
    int countQuantities();

    @Query("select count(d.id) from Donation d")
    int countDonations();

}
