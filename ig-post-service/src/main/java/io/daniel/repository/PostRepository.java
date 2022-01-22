package io.daniel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.daniel.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findAllByUserId(String userId);
	
}
