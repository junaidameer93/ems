package com.ems.webapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Post;
import com.ems.service.api.PostService;

@RestController
@RequestMapping("api/post")
public class PostWebApi {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Post post) {
		Post savedPost = postService.save(post);
		if (savedPost == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
	}
	

 	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Optional<Post> post = postService.getById(id);
		if (post.isPresent()) {
			return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}
 	
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Post post = postService.findById(id);
		if (post != null) {
			return new ResponseEntity<Post>(post, HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}

  	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getAll() {
		List<Post> obj = postService.getAll();
		return new ResponseEntity<List<Post>>(obj, HttpStatus.OK);
  	}
  	
  	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
	public ResponseEntity<?> findByTitle(@PathVariable("title") String title) {
  		Optional<Post> obj = postService.getByTitle(title);
		if (obj.isPresent()) {
			return new ResponseEntity<Post>(obj.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
  	}
}
