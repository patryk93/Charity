package pl.coderslab.charity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.UserLoginData;


@Repository
public interface UserLoginDataRepository extends JpaRepository<UserLoginData, Long> {

    @Query("SELECT CASE WHEN count(uld.id) > 0 THEN true ELSE false END " +
            "FROM UserLoginData uld WHERE uld.user.email = :email AND uld.password = :password")
    Boolean checkCredentials(@Param("email") String email, @Param("password") String password);
}
