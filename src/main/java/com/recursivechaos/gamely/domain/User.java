/**
 * Created by Andrew Bell 2/22/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.domain;

import lombok.Data;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private String facebookId;
    private LocalDateTime lastLogin;

    public User(Principal principal) {
        OAuth2Authentication auth = (OAuth2Authentication) principal;
        this.facebookId = auth.getName();
        Map<String, String> details = (Map<String, String>) auth.getUserAuthentication().getDetails();
        this.name = details.get("name");
        this.lastLogin = LocalDateTime.now();
    }

}
