package com.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.PostDao;
import com.ems.model.Post;
import com.ems.repository.PostRepository;
import com.ems.service.api.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private PostDao postDao;

	public Post save(Post obj) {
		logger.info("save method started for Post: " + obj.toString());
		try {
			Post savedObj = repository.save(obj);
			logger.info("Successfully save Post");
			return savedObj;
		} catch (Exception e) {
			logger.error("Error while saving Post");
			logger.error(e.getMessage());
		}
		return null;
	}

	public Optional<Post> getById(Integer id) {
		return repository.findById(id);
	}
	
	public Post findById(Integer id) {
		return postDao.getById(id);
	}

	public Optional<Post> getByTitle(String name) {
		return repository.findByTitle(name);
	}

	public void update(Post obj) {

	}

	public void delete(Post obj) {

	}

	public void delete(Integer id) {

	}

	public List<Post> getAll() {
		List<Post> list=repository.findAll();
		return list;
	}

}
