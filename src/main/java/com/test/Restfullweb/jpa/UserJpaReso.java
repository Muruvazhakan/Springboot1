package com.test.Restfullweb.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.Person.Personv1;
import com.test.Person.Personv2;
import com.test.user.post.Post;
import com.test.Name;
import com.test.User;
import com.test.UserDoaService;
import com.test.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaReso {

	private UserRepository repo;
	private UserPostRepository postrepo;

	public UserJpaReso(UserRepository repo,UserPostRepository postrepo) {
		this.postrepo=postrepo;
		this.repo = repo;
	}

	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return repo.findAll();

	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {

		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);

		}
		return user;
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getpostforuser(@PathVariable int id) {
		
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);

		}
		
		return user.get().getPosts();

	}

	@DeleteMapping("jpa/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		repo.deleteById(id);

	}

	@PostMapping("/jpa/users")
	public void createUser(@Valid @RequestBody User user) {
		User savedUser = repo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPostforUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);

		}
		post.setUser(user.get());
		Post savedpost = postrepo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedpost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
		
		
	}

}
