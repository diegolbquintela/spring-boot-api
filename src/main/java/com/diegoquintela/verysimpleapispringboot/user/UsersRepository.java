package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //responsible for data access
public interface UsersRepository extends JpaRepository<Users, Long> {

//    Implementing search functionality
//    SELECT * FROM users WHERE email = whatever we pass if we don't use @Query
    @Query("SELECT s FROM Users s WHERE s.email = ?1") //JBQL
    Optional<Users> findUsersByEmail(String email);

}
