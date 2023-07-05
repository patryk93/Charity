package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;


    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role user = new Role();
        user.setId(1);
        user.setName("USER");

        Role admin = new Role();
        admin.setId(2);
        admin.setName("ADMIN");

       roleRepository.save(user);
       roleRepository.save(admin);
    }
}
