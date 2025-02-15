package org.example.simplemvc;

import org.example.simplemvc.models.User;
import org.example.simplemvc.models.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repo) {

        return args -> {
            User nikola = new User(
                    "Nikola Milosevic",
                    "nikola_m@gmail.com"
            );

            User marko = new User(
                    "Marko Markovic",
                    "marko_m@gmail.com"
            );

            User petar = new User(
                    "Petar Petrovic",
                    "petar_p@gmail.com"
            );

            repo.saveAll(List.of(nikola, marko, petar));

        };

    }

}
