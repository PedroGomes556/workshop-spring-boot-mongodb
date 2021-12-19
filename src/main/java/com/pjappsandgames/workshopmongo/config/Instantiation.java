package com.pjappsandgames.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pjappsandgames.workshopmongo.domain.Post;
import com.pjappsandgames.workshopmongo.domain.User;
import com.pjappsandgames.workshopmongo.dto.AuthorDTO;
import com.pjappsandgames.workshopmongo.dto.CommentDTO;
import com.pjappsandgames.workshopmongo.reposity.PostReposity;
import com.pjappsandgames.workshopmongo.reposity.UserReposity;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private UserReposity userReposity;
	
	@Autowired 
	private PostReposity postReposity;
	
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposity.deleteAll();
		postReposity.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposity.saveAll(Arrays.asList(alex, maria, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));             
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bomd dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));	
		
		postReposity.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userReposity.save(maria);
	}

	
	
}
