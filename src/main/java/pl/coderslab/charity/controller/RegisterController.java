package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.mapper.UserMapper;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    private static final String REGISTER = "register";
    private final UserService userService;

    private final UserMapper userMapper;

    private final RoleService roleService;

    public RegisterController(UserService userService, UserMapper userMapper, RoleService roleService) {
        this.userService = userService;

        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @ModelAttribute("roles")
    public List<Role> roles() {
        return roleService.findAll();
    }

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("registerForm", new User());
        return REGISTER;
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute(name = "registerForm") @Valid UserDTO userDTO, BindingResult result) {
        if (userService.findByEmail(userDTO.getEmail()) != null) {
            result.rejectValue("email", "error.user", "Użytkownik o takim adresie email już istnieje");
        }
        if (result.hasErrors()) {
            return "register";
        }
        User user = userMapper.toModel(userDTO);
        userService.saveUser(user);

        return "index";
    }
    }



