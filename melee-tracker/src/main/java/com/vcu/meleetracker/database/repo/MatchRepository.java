package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Integer> {
}

