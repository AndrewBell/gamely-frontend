/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.service;

import com.recursivechaos.gamely.domain.User;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class UserService {

    private static final Logger logger = getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @NotNull
    public User getUser(Principal principal) {
        OAuth2Authentication auth = (OAuth2Authentication) principal;
        String facebookId = auth.getName();
        User user = userRepository.findOneByFacebookId(facebookId);
        logger.debug("Attempting to get user returned {}", user);
        if (null == user) {
            user = registerUser(principal);
            logger.debug("New user created {}", user);
        }
        assert (null != user);
        return user;
    }

    private User registerUser(Principal principal) {
        return userRepository.save(new User(principal));
    }

}
