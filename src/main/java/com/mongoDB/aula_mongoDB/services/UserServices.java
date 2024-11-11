package com.mongoDB.aula_mongoDB.services;

import com.mongoDB.aula_mongoDB.domain.entities.User;
import com.mongoDB.aula_mongoDB.dto.UserDTO;
import com.mongoDB.aula_mongoDB.repository.UserRepository;
import com.mongoDB.aula_mongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new ObjectNotFoundException("Object not found !!");
        }
        return user.get();
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
    }

}
