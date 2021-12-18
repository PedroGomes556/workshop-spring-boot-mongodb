package com.pjappsandgames.workshopmongo.reposity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pjappsandgames.workshopmongo.domain.Post;

@Repository
public interface PostReposity extends MongoRepository<Post, String>{
	
	
}
