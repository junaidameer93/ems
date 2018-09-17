package com.ems.dao;

import java.util.List;
import java.util.Optional;

import com.ems.model.Post;

public interface PostDao {
	Post save(Post obj);

	Post getById(Integer id);

	List<Post> getAll();

	Optional<Post> getByTitle(String name);

	void update(Post obj);

	void delete(Post obj);

	void delete(Integer id);
}
