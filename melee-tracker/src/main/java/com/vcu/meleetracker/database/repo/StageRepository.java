package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Stage;
import org.springframework.data.repository.CrudRepository;

public interface StageRepository extends CrudRepository<Stage,Integer> {
}
