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
