package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service //needs to be a Bean (to be instantiated), we use @Component/@Service for that
public class UserService {


    public List<User> getUsers() {
        return List.of(new User(1L, "Mariam", LocalDate.of(2000, Month.APRIL, 5), "mariam@email.com", 21)
        );

    }
}
