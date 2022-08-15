package com.aroosha.exersice.model.repository;

import com.aroosha.exersice.model.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
