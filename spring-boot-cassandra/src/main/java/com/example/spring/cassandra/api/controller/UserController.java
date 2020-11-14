package com.example.spring.cassandra.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.cassandra.api.model.User;
import com.example.spring.cassandra.api.rpository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(5984, "My name is Jeff", "Groove Street", 45));
		users.add(new User(2333, "Daniel", "Tiquicia", 20));
		users.add(new User(324233, "Test", "CR", 24));
		repository.saveAll(users);
	}

	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age) {
		return repository.findById(age);
	}
	
	@GetMapping("/deleteById/{id}")
	public List<User> deleteById(@PathVariable int id) {
		return repository.deleteById(id);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		return repository.insert(user);
	}
}
