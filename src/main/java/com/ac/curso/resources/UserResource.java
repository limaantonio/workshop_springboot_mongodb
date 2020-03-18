package com.ac.curso.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ac.curso.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "Maria@gmail.com");
		User a = new User("2", "Alex", "a@gmail.com");
		
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria, a));
		
		return ResponseEntity.ok().body(users);
	}
}
