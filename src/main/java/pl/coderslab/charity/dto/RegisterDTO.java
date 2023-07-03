package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import org.mindrot.jbcrypt.BCrypt;

@Getter
@Setter
public class RegisterDTO {

    @NotNull @NotBlank (message = "Pole nie może być puste") @Email (message = "Niepoprawny email")
    private String email;
    @NotNull @NotBlank (message = "Pole nie może być puste")
    private String password;
    @NotNull @NotBlank (message = "Pole nie może być puste")
    private String confirmedPassword;
    @NotNull (message = "Pole nie może być puste") @Size(min = 3, message = "Imię musi być dłuższe niż 3 znaki" )
    private String firstName;
    @NotNull (message = "Pole nie może być puste") @Size(min = 3, message = "Imię musi być dłuższe niż 3 znaki" )
    private String lastName;

}
