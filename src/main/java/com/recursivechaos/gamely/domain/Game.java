/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue
    Integer id;
    String name;

    public Game(String name) {
        this.name = name;
    }

}
