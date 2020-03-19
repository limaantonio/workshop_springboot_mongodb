package com.ac.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ac.curso.domain.Post;
import com.ac.curso.domain.User;
import com.ac.curso.dto.AuthorDTO;
import com.ac.curso.dto.CommentDTO;
import com.ac.curso.repositories.PostRepository;
import com.ac.curso.repositories.UserRepository;

@Configuration
public class Instantiaton implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRespository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRespository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRespository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/01/2013"), "Partiu viajem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano",sdf.parse("21/03/2018"), new AuthorDTO(alex));
		
		post1.getComment().addAll(Arrays.asList(c1));
		
		postRepository.saveAll(Arrays.asList(post1));
		maria.getPosts().addAll(Arrays.asList(post1));
		
		
		
		userRespository.save(maria);
		
		
		
	}

}
