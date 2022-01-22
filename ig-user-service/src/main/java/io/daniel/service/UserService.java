package io.daniel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.daniel.models.User;
import io.daniel.models.Users;
import io.daniel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(user -> users.add(user));

		Users _users = new Users(users);
		return _users;
	}

	public Users getUserByUserName(String userName) {
		List<User> users = new ArrayList<>();
		users.add(userRepository.findByUserName(userName));
		return new Users(users);
	}

	public User getUserById(String userId) {
		return userRepository.findByUserId(userId);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User editUser(String userId, User user) {
		return userRepository.save(user);
//		String _userId = user.getUserId();
//
//		if (userId == _userId) {
//			return userRepository.save(user);
//		} else if (_userId == null) {
//			user.setUserId(userId);
//			return userRepository.save(user);
//		} else {
//			return null;
//		}
	}

}
