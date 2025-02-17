package org.example.simplemvc.repos;

import org.example.simplemvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.email=?1")
    Optional<User> findByEmail(String username);

    boolean existsByEmail(String email);

}
