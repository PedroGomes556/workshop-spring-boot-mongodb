package com.pjappsandgames.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjappsandgames.workshopmongo.domain.User;
import com.pjappsandgames.workshopmongo.reposity.UserReposity;

@Service
public class UserService {

	@Autowired
	private UserReposity repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
}
