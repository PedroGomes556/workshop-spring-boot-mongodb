package com.pjappsandgames.workshopmongo.reposity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pjappsandgames.workshopmongo.domain.Post;

@Repository
public interface PostReposity extends MongoRepository<Post, String>{
	
	@Query("{ 'tile': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
}
