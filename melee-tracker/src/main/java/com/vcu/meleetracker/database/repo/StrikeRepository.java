package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Strike;
import org.springframework.data.repository.CrudRepository;

public interface StrikeRepository extends CrudRepository<Strike, Integer> {
}
