package com.recursivechaos.gamely.controller;

import com.recursivechaos.gamely.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User user(Principal principal) {
        return new User(principal);
    }

}
