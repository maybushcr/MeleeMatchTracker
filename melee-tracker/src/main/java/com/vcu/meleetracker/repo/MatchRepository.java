package com.vcu.meleetracker.repo;

import com.vcu.meleetracker.domain.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Integer> {
}

