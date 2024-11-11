package com.mongoDB.aula_mongoDB.config;

import com.mongoDB.aula_mongoDB.domain.entities.Post;
import com.mongoDB.aula_mongoDB.domain.entities.User;
import com.mongoDB.aula_mongoDB.dto.AuthorDTO;
import com.mongoDB.aula_mongoDB.repository.PostRepository;
import com.mongoDB.aula_mongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post = new Post(null,simpleDateFormat.parse("21/03/2018"),"Partiu Viagem", "Vou viajar para são Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null,simpleDateFormat.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje !!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post,post2));

        maria.getPosts().addAll(Arrays.asList(post,post2));
        userRepository.save(maria);
    }


}
