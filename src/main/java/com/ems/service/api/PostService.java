package com.ems.service.api;

import java.util.List;
import java.util.Optional;
import com.ems.model.Post;

public interface PostService {
	Post save(Post obj);

	Optional<Post> getById(Integer id);

	List<Post> getAll();

	Optional<Post> getByTitle(String name);

	Post findById(Integer id);

	void update(Post obj);

	void delete(Post obj);

	void delete(Integer id);
}
