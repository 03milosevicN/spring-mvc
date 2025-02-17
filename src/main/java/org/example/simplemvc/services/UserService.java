package org.example.simplemvc.services;

import org.example.simplemvc.models.User;
import org.example.simplemvc.payloads.UserDTO;
import org.example.simplemvc.repos.UserRepository;
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


    public boolean registerUser(UserDTO userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())) {
            log.info("User with email {} already exists", userDTO.getEmail());
        }

        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
        userRepository.save(user);
        return true;

    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            log.info("Cannot delete user with id {}", id);
            log.info("User with id {} does not exist!", id);
        }
        userRepository.deleteById(id);
    }



}
