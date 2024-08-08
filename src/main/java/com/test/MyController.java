package com.test;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.Person.Personv1;
import com.test.Person.Personv2;
import com.test.User;

import jakarta.validation.Valid;

@RestController
public class MyController {
	
private UserDoaService serv; 
	
	public MyController(UserDoaService serv) {
		this.serv = serv;
	}

	@GetMapping("/getData")
	public String getData() {
		return "Hello project";
	}
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return serv.findAll();
		
	}
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id){
	
		User user= serv.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id: "+id);
			
		}
		return user;
	}
	@PostMapping("/users")
	public void createUser(@Valid @RequestBody User user) {
		User savedUser = serv.create(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		serv.deleteUser(id);
		
	}
	
	@GetMapping("/v1/person")
	public Personv1 getFirstVer() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecVer() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
}  


