package com.mongoDB.aula_mongoDB.resource;

import com.mongoDB.aula_mongoDB.domain.entities.Post;
import com.mongoDB.aula_mongoDB.domain.entities.User;
import com.mongoDB.aula_mongoDB.dto.UserDTO;
import com.mongoDB.aula_mongoDB.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userServices.findAll();
        List<UserDTO> userDTOList = list.stream().map(u -> new UserDTO(u)).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userServices.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userServices.fromDTO(userDTO);
        user = userServices.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
        User user = userServices.fromDTO(userDTO);
        user.setId(id);
        userServices.update(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User user = userServices.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

}
