package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.TournamentType;
import org.springframework.data.repository.CrudRepository;

public interface TournamentTypeRepository extends CrudRepository<TournamentType, Integer> {
}
