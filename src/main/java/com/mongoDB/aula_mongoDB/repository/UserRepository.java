package com.mongoDB.aula_mongoDB.repository;

import com.mongoDB.aula_mongoDB.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
