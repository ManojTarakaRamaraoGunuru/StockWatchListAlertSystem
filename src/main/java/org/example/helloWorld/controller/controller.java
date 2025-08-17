package org.example.helloWorld.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Hello World from HelloWorld service!");
        return "index"; // resolves to src/main/resources/templates/index.html
    }
}
