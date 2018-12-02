package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
