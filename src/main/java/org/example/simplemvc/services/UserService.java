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


@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     *
     * @param userDTO : DTO of model User
     * @return true if UserDTO's e-mail isn't already present in the database
     */
    public boolean registerUser(UserDTO userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())) {
            log.info("User with email {} already exists", userDTO.getEmail());
            return false;
        }

        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getRole());
        userRepository.save(user);
        return true;

    }



    /**
     *
     * @param email : User's email
     * @param password : User's password
     * @return true if acquired password matches password in database
     */
    public boolean validateLogin(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user == null) {
            log.info("User with email {} does not exist", email);
            return false;
        }

        return user.getPassword().equals(password);
    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            log.info("Cannot delete user with id {}", id);
            log.info("User with id {} does not exist!", id);
        }
        userRepository.deleteById(id);
    }



}
