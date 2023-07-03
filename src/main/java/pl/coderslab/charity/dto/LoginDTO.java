package pl.coderslab.charity.dto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
public class LoginDTO {
    @NotNull @NotBlank
    private String email;
    @NotNull @NotBlank
    private String password;

}
