package io.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.daniel.models.Comment;
import io.daniel.models.Comments;
import io.daniel.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comments getAllComments(Integer postId) {
		List<Comment> comments = commentRepository.findAllByPostId(postId);
				
		return new Comments(comments);
	}
	
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public Comment editComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
}
