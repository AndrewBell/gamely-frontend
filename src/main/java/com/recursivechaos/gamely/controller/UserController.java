/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.controller;

import com.recursivechaos.gamely.domain.User;
import com.recursivechaos.gamely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User user(Principal principal) {
        return userService.getUser(principal);
    }

}
