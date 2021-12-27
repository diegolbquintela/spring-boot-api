package com.diegoquintela.verysimpleapispringboot;

import com.diegoquintela.verysimpleapispringboot.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController //makes class serve REST endpoints
public class VerySimpleApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerySimpleApiSpringBootApplication.class, args);
    }


}
