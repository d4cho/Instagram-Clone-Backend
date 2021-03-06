package io.daniel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.daniel.models.Post;
import io.daniel.models.Posts;
import io.daniel.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Posts getAllPosts() {
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(post -> posts.add(post));

		Posts _posts = new Posts(posts);
		return _posts;
	}

	public Posts getAllPostsByUserId(String userId) {
		List<Post> posts = new ArrayList<>();
		postRepository.findAllByUserId(userId).forEach(post -> posts.add(post));

		Posts _posts = new Posts(posts);
		return _posts;
	}

	public Post addPost(Post post) {
		return postRepository.save(post);
	}

	public Post editPost(Post post) {
		return postRepository.save(post);
	}

	public Post getPostByPostId(Integer postId) {
		return postRepository.findById(postId).get();
	}

}
