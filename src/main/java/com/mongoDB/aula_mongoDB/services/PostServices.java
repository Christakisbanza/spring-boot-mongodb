package com.mongoDB.aula_mongoDB.services;

import com.mongoDB.aula_mongoDB.domain.entities.Post;
import com.mongoDB.aula_mongoDB.domain.entities.User;
import com.mongoDB.aula_mongoDB.dto.UserDTO;
import com.mongoDB.aula_mongoDB.repository.PostRepository;
import com.mongoDB.aula_mongoDB.repository.UserRepository;
import com.mongoDB.aula_mongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()){
            throw new ObjectNotFoundException("Object not found !!");
        }
        return post.get();
    }

    public List<Post> findByTitle(String txt){
        return postRepository.searchTitle(txt);
    }

}
