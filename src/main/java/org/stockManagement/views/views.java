package org.stockManagement.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Here we are doing server side rendering for the very first entry point and some entry points that
// will be called from js that's why using @Controller, this will send -- json, html, xml and so on
// Unlike api first (industrial standard approach) we will only deal with json outputs
// that are managed by @RestController,  placing them in their corresponding dirs

@Controller
public class views {

    @GetMapping("/dashboard")
    public String RenderIndex(){
        return "index";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup"; // resolves templates/signup.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // resolves templates/login.html
    }

    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage"; // resolves templates/homepage.html
    }
}
