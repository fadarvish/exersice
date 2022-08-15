package com.aroosha.exersice.model.repository;

import com.aroosha.exersice.model.entity.PersonInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PersonInfoRepository extends CrudRepository<PersonInfo,Integer> {

}
