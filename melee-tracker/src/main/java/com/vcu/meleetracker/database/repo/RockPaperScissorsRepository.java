package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.RockPaperScissors;
import org.springframework.data.repository.CrudRepository;

public interface RockPaperScissorsRepository extends CrudRepository<RockPaperScissors,Integer> {
}
