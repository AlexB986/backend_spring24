package org.example.backend_spring.config;

import org.example.backend_spring.model.Role;
import org.example.backend_spring.model.User;
import org.example.backend_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


@Configuration
public class IntinUserToDb {
    @Autowired
    private UserRepository userRepository;


    public IntinUserToDb(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        if (userRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setRole("ROLE_ADMIN");
            Role userRole = new Role();
            userRole.setRole("ROLE_USER");


            User admin = new User();
            admin.setName("a");
            admin.setAge(15);
            admin.setUsername("admin");
            //password admin
            admin.setPassword("$2a$10$OJBMBLkwm9KUH89x4bKGXOlVPs7Q8SUSF5C76QEPVfqn9E0nOnIeK");
            admin.addUserToRole(adminRole);

            User user = new User();
            user.setUsername("user");
            user.setName("u");
            //password user
            user.setPassword("$2a$10$OesBcZlQcNrTCiVBQ98cjeWkc.JBNywH3pN0wALqo5Ju4UIZJ6mXG");
            user.setAge(94);
            user.addUserToRole(userRole);


            userRepository.save(admin);
            userRepository.save(user);
        } else {
            System.out.println("Есть пользователи");
        }

    }
}
