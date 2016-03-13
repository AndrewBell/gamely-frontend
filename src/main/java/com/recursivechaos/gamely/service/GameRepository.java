/**
 * Created by Andrew Bell 3/12/2016
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2016. See license.txt for details.
 */

package com.recursivechaos.gamely.service;

import com.recursivechaos.gamely.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
