package io.daniel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.daniel.models.User;
import io.daniel.models.Users;
import io.daniel.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/private")
	public Users getUsers(@RequestParam(value = "userName", required = false) String userName) {
		if (userName != null) {
			return userService.getUserByUserName(userName);
		}
		return userService.getAllUsers();
	}

	@GetMapping("/private/{userId}")
	public User getUserById(@PathVariable("userId") String userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/public/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/private/edit/{userId}")
	public User editUser(@PathVariable("userId") String userId, @RequestBody User user) {
		return userService.editUser(userId, user);
	}

}
