package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //needs to be a Bean (to be instantiated), we use @Component/@Service for that
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired //makes a reference be autowired and automatically injected into constructor
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public void addNewUsers(Users users) {
        Optional<Users> usersOptional = usersRepository.findUsersByEmail(users.getEmail());

        // validation
        if (usersOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        // if email not taken, save user
        usersRepository.save(users);
        System.out.println(users);
    }

    public void deleteUsers(Long usersId) {
        boolean exists = usersRepository.existsById(usersId);

        if (!exists) {
            throw new IllegalStateException("user with id " + usersId + " does not exist.");
        }

        usersRepository.deleteById(usersId);
    }

    // PUT requests
    // with @Transactional (Spring Data JPA) we don't have to implement any JPQL Query, using the setters to check if can/can't update
    @Transactional
    public void updateUsers(Long usersId, String name, String email) {
        Users users = usersRepository.findById(usersId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + usersId + " does not exists"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(users.getName(), name)) {
            users.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(users.getEmail(), email)) {
            Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
            if (usersOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            users.setEmail(email);
        }

    }
}
