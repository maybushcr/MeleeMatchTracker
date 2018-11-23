package com.vcu.meleetracker.repo;

import com.vcu.meleetracker.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
