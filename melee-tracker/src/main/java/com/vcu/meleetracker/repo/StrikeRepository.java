package com.vcu.meleetracker.repo;

import com.vcu.meleetracker.domain.Strike;
import org.springframework.data.repository.CrudRepository;

public interface StrikeRepository extends CrudRepository<Strike, Integer> {
}
