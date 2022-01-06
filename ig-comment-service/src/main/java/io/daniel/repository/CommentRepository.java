package io.daniel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.daniel.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findAllByPostId(Integer postId);

}