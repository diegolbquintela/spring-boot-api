package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;

@Configuration
public class UsersConfig {

    //adding bean
    // giving access to repository
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository) {
        return args -> {
            Users mariam = new Users("Mariam", LocalDate.of(2000, APRIL, 5), "mariam@email.com");
            Users richard = new Users("Richard", LocalDate.of(2010, APRIL, 5), "richard@email.com" );

            // adding users to db
            repository.saveAll(
                    List.of(mariam, richard)
            );
        };


    }
}
