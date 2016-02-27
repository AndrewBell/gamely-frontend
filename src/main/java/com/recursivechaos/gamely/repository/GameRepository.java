package com.recursivechaos.gamely.repository;

import com.recursivechaos.gamely.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
