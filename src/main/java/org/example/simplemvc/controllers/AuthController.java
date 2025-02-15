package org.example.simplemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    /**
     * Handles GET request for "login.html".
     *
     * @return name of view template for "login.html".
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    /**
     * Handles GET request for "register.html".
     * @return name of view template for "register.html".
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
