package com.vcu.meleetracker.repo;

import com.vcu.meleetracker.domain.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Integer> {
}
