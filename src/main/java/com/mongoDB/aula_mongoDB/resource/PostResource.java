package com.mongoDB.aula_mongoDB.resource;

import com.mongoDB.aula_mongoDB.domain.entities.Post;
import com.mongoDB.aula_mongoDB.domain.entities.User;
import com.mongoDB.aula_mongoDB.dto.UserDTO;
import com.mongoDB.aula_mongoDB.resource.util.URL;
import com.mongoDB.aula_mongoDB.services.PostServices;
import com.mongoDB.aula_mongoDB.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices postServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postServices.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String txt){
        txt = URL.decodeParam(txt);
        List<Post> list = postServices.findByTitle(txt);
        return ResponseEntity.ok().body(list);
    }
}
