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

import io.daniel.models.FullComments;
import io.daniel.models.FullPost;
import io.daniel.models.FullPosts;
import io.daniel.models.Post;
import io.daniel.models.Posts;
import io.daniel.models.User;
import io.daniel.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping
	public FullPosts getAllPosts() {

		Posts posts = postService.getAllPosts();

		List<FullPost> _fullPosts = posts.getPosts().stream().map(post -> {

			User user = webClientBuilder
					.filter(new ServletBearerExchangeFilterFunction())	// to propagate Authorization token in header
					.build()
					.get()
					.uri("http://ig-user-service/users/private/" + post.getUserId())
					.retrieve()
					.bodyToMono(User.class)
					.block();
			
			FullComments fullComments = webClientBuilder
					.filter(new ServletBearerExchangeFilterFunction())	// to propagate Authorization token in header
					.build()
					.get()
					.uri("http://ig-comment-service/comments/" + post.getPostId())
					.retrieve()
					.bodyToMono(FullComments.class)
					.block();

			return new FullPost(post.getPostId(), post.getUserId(), post.getLikeCount(), post.getImage(),
					post.getPostDesc(), user.getUserName(), user.getImage(), fullComments);
			
		}).collect(Collectors.toList());
		
		return new FullPosts(_fullPosts);
	}
	
	@GetMapping("/{postId}")
	public FullPost getPostById(@PathVariable("postId") Integer postId) {
		
		Post post = postService.getPostByPostId(postId);

		User user = webClientBuilder
				.filter(new ServletBearerExchangeFilterFunction())	// to propagate Authorization token in header
				.build()
				.get()
				.uri("http://ig-user-service/users/private/" + post.getUserId())
				.retrieve()
				.bodyToMono(User.class)
				.block();
		
		FullComments fullComments = webClientBuilder
				.filter(new ServletBearerExchangeFilterFunction())	// to propagate Authorization token in header
				.build()
				.get()
				.uri("http://ig-comment-service/comments/" + post.getPostId())
				.retrieve()
				.bodyToMono(FullComments.class)
				.block();
		
		return new FullPost(post.getPostId(), post.getUserId(), post.getLikeCount(), post.getImage(),
				post.getPostDesc(), user.getUserName(), user.getImage(), fullComments);
	}

	@GetMapping("/user/{userId}")
	public Posts getAllPostsByUserId(@PathVariable("userId") String userId) {
		return postService.getAllPostsByUserId(userId);
	}

	@PostMapping
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}

	@PutMapping("/{postId}")
	public Post editPost(@RequestBody Post post) {
		return postService.editPost(post);
	}

}
