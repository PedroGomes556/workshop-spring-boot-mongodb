package com.pjappsandgames.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pjappsandgames.workshopmongo.domain.User;
import com.pjappsandgames.workshopmongo.reposity.UserReposity;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private UserReposity userReposity;
	
	
	@Override
	public void run(String... args) throws Exception {

		userReposity.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userReposity.saveAll(Arrays.asList(alex, maria, bob));
	}

	
	
}
