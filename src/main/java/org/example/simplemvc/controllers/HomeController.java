package org.example.simplemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Handles GET request for "home.html".
     *
     * @return name of view template for "home.html".
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
