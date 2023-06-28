package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.UserLoginData;
import pl.coderslab.charity.repository.UserLoginDataRepository;
import pl.coderslab.charity.repository.UserRepository;


@RequiredArgsConstructor
@Service
public class RegisterService {


    private final UserLoginDataRepository userLoginDataRepository;


    private final UserRepository userRepository;

    public void register(RegisterDTO form) {
        String email = form.getEmail();
        String firstName = form.getFirstName();
        String lastName = form.getLastName();
        String password = form.getPassword();

        Boolean emailUsed = userRepository.isEmailUsed(email);
        if (emailUsed != null && emailUsed) {
            throw new IllegalArgumentException("Email zajęty");
        }
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
        userRepository.save(user);


        UserLoginData loginData = new UserLoginData();
        loginData.setUser(user);
        loginData.setPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
        userLoginDataRepository.save(loginData);

    }
}