package com.pjappsandgames.workshopmongo.reposity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pjappsandgames.workshopmongo.domain.User;

@Repository
public interface UserReposity extends MongoRepository<User, String>{
	
	
	
	
}
