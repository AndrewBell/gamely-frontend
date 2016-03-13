/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.service;

import com.recursivechaos.gamely.domain.Card;
import com.recursivechaos.gamely.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRespository extends JpaRepository<Card,Integer>{

    List<Card> findAllByUser(User user);

}
