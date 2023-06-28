package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.RegisterDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.charity.service.RegisterService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private static final String REGISTER = "register";

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterService registerService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("registerForm", new User());
        return REGISTER;
    }

    @PostMapping("/register")
    public String registrationToModel(@ModelAttribute("registerForm") @Valid RegisterDTO form,
                                      BindingResult results, Model model){


//        if (password.equals(password2)){
//            User user = new User(firstName,lastName,email,BCrypt.hashpw(password,BCrypt.gensalt()));
//            userService.save(user);
//        }
//        else{
//            return "register";
//        }
//        return "redirect:/login";

        if (results.hasErrors()) {
            return REGISTER;
        }
        if (!form.getConfirmedPassword().equals(form.getPassword())) {
            results.rejectValue("password","errors.notmatch","Podane hasła różnią się od siebie");
            return REGISTER;
        }
        try {
            registerService.register(form);
            return "redirect:/";
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            results.rejectValue("email", "errors.nonunique", "E-mail już istnieje");
            return REGISTER;
        } catch (RuntimeException re) {
            re.printStackTrace();
            model.addAttribute("error", true);
            return REGISTER;
        }
    }
    }


