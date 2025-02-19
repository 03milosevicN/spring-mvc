package org.example.simplemvc.controllers;

import org.example.simplemvc.payloads.UserDTO;
import org.example.simplemvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles GET request for "login.html".
     *
     * @return name of view template for "login.html".
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    /**
     * @param userDTO : DTO of entity User
     * @param model : hold Model attributes
     * @return redirection to view template for "success.html"
     */
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") UserDTO userDTO, Model model) {

        if (!userService.validateLogin(userDTO.getEmail(), userDTO.getPassword())) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        return "redirect:/success";
    }


    /**
     * Handles GET request for "register.html".
     * @return name of view template for "register.html".
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    /**
     * @param userDTO :  DTO of entity User
     * @param model : hold Model attributes
     * @return redirect to success page if successfully added to database.
     */
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") UserDTO userDTO, Model model) {

        if (!userService.registerUser(userDTO)) {
            model.addAttribute("error", "User with email " + userDTO.getEmail() + " already exists");
            return "register";
        }

        return "redirect:/login";
    }


    /**
     * Temporary solution for a successful registration
     * @return name of view template for "success.html"
     */
    @GetMapping("/success")
    public String success() {
        return "success";
    }

}
