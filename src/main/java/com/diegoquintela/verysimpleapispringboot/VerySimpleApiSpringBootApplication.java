package com.diegoquintela.verysimpleapispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //makes class serve REST endpoints
public class VerySimpleApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerySimpleApiSpringBootApplication.class, args);
    }


}
