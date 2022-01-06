package io.daniel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.daniel.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);

}
