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

	public Posts getAllPostsByUserId(Integer userId) {
		List<Post> posts = new ArrayList<>();
		postRepository.findAllByUserId(userId).forEach(post -> posts.add(post));

		Posts _posts = new Posts(posts);
		return _posts;
	}

	public Post addPost(Post post) {
		postRepository.save(post);
		return post;
	}

	public Post editPost(Integer postId, Post post) {
		Integer _postId = post.getUserId();

		if (postId == _postId) {
			return postRepository.save(post);
		} else if (_postId == null) {
			post.setPostId(postId);
			return postRepository.save(post);
		} else {
			return null;
		}
	}

	public Post getPostByPostId(Integer postId) {
		return postRepository.findById(postId).get();
	}

}
