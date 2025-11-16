package org.stockManagement.views;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class health {
    @GetMapping("/health-check")
    public String healthStatus(){
        return "Ok";
    }
}
