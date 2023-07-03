package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE name = ?1 AND enabled = 1", nativeQuery = true)
    User findUserByName(String name);


    @Query("SELECT true FROM User u WHERE u.email = :email")
    Boolean isEmailUsed(@Param("email") String email);

    User findByEmail(String email);

}
