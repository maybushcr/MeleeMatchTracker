package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Integer> {
}
