package org.example.simplemvc.services;

import org.example.simplemvc.models.User;
import org.example.simplemvc.models.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            log.info("User with email {} already exists", user.getEmail());
        }

        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            log.info("Cannot delete user with id {}", id);
            log.info("User with id {} does not exist!", id);
        }
        userRepository.deleteById(id);
    }

}
