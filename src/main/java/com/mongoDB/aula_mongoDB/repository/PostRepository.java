package com.mongoDB.aula_mongoDB.repository;

import com.mongoDB.aula_mongoDB.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
