package io.daniel.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.web.reactive.function.client.ServletBearerExchangeFilterFunction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.daniel.models.Comment;
import io.daniel.models.Comments;
import io.daniel.models.FullComment;
import io.daniel.models.FullComments;
import io.daniel.models.User;
import io.daniel.service.CommentService;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/{postId}")
	public FullComments getAllCommentsByPostId(@PathVariable("postId") Integer postId) {
		Comments comments = commentService.getAllComments(postId);
				
		List<FullComment> _fullComments = comments.getComments().stream().map(comment -> {
			
			User user = webClientBuilder
					.filter(new ServletBearerExchangeFilterFunction())	// to propagate Authorization token in header
					.build()
					.get()
					.uri("http://ig-user-service/users/private/" + comment.getUserId())
					.retrieve()
					.bodyToMono(User.class)
					.block();
			
			return new FullComment(comment.getCommentId(), comment.getUserId(), comment.getPostId(), comment.getCommentText(), comment.getLikeCount(),
					user.getUserName(), user.getImage());
			
		}).collect(Collectors.toList());
		
		return new FullComments(_fullComments);
	}

	@PostMapping
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}

	@PutMapping("/{userId}")
	public Comment editComment(@RequestBody Comment comment) {
		return commentService.editComment(comment);
	}

}
