/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.service;

import com.recursivechaos.gamely.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByFacebookId(String facebookId);

}
