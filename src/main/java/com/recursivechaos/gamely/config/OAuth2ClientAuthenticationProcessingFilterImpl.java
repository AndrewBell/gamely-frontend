/**
 * Created by Andrew Bell 2/23/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.config;

import com.recursivechaos.gamely.domain.User;
import com.recursivechaos.gamely.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class OAuth2ClientAuthenticationProcessingFilterImpl extends OAuth2ClientAuthenticationProcessingFilter {

    UserRepository userRepository;

    private static final Logger logger = getLogger(OAuth2ClientAuthenticationProcessingFilterImpl.class);

    public OAuth2ClientAuthenticationProcessingFilterImpl(String path, UserRepository userRepository) {
        super(path);
        this.userRepository = userRepository;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        logger.info("User successfully authenticated with FB ID: {}", authResult.getName());
        User user = userRepository.findFirstByFacebookId(authResult.getName());
        if (null == user) {
            User savedUser = userRepository.save(new User(authResult));
            logger.info("New user registered with ID: {}" + savedUser.getId());
        }
    }
}
