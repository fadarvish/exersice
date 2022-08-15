package com.aroosha.exersice.model.repository;

import com.aroosha.exersice.model.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document,Integer>
{
}
