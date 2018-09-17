package com.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	Optional<Post> findByTitle(String name);
}
