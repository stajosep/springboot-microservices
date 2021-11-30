package com.staphy.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.staphy.rest.webservices.restfulwebservices.post.Post;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;

	// retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// retrieve single user
	@GetMapping(path = "/users/{id}")
//	public EntityModel<User> retrieveUserById(@PathVariable int id) {
//		User user = service.findOne(id);
//		if (user == null) {
//			throw new UserNotFoundException("id-"+id);
//		}
//		
//		//HATEOAS
//		//create a link to all-users to be passed along with the resource
//		EntityModel<User> userResource = EntityModel.of(user);
//		
//		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//		
//		userResource.add(link.withRel("all-users"));
//		
//		return userResource;
//	}
	public User retrieveUserById(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return user;
	}

	// input -details of a user
	// output - CREATED status and return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//CREATED status
		// URI to be returned /users/{saved users id}
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// retrieve single user
		@DeleteMapping("/users/{id}")
		public void deleteUserById(@PathVariable int id) {
			User user = service.deleteById(id);
			if (user == null) {
				throw new UserNotFoundException("id-"+id);
			}
		}
	 
	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePostsByUser(@PathVariable int id) {
		return service.findUserPosts(id);
	}
	
	@PostMapping("/users/{id}/posts")
	public void createPost(@PathVariable int id, @RequestBody Post post) {
		service.saveUserPosts(id, post);
	}
}
