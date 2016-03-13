/**
 * Created by Andrew Bell 3/13/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.controller;

import com.recursivechaos.gamely.domain.Card;
import com.recursivechaos.gamely.service.CardRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/cards")
public class CardController {

    @Autowired
    CardRespository cardRespository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCard(Card card, Principal principal){
        return null;
    }

}
