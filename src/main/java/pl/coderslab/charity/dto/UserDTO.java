package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Repository
public class UserDTO implements Serializable {

    private Long id;

    @NotBlank
    private String email;

    private int enabled;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String password;

    private Set<String> rolesNames = new HashSet<>();

}
