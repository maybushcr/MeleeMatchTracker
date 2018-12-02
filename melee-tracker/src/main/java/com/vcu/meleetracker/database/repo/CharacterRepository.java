package com.vcu.meleetracker.database.repo;

import com.vcu.meleetracker.database.domain.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
