package com.vcu.meleetracker.repo;

import com.vcu.meleetracker.domain.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
