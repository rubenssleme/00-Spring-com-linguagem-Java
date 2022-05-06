package com.rubensleme.apicurso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubensleme.apicurso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(5L, "Samuel", "RubensLeme@", "11 9 9999-6666", "123456");
		return ResponseEntity.ok().body(u);
	}

}
