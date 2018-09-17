package com.ems.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.model.Post;
import com.ems.util.EmsUtil;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	EmsUtil emsUtil;

	public Post save(Post obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getById(Integer id) {
		SessionFactory sessionFactory = emsUtil.getHibernateFactory();
		Session session = sessionFactory.getCurrentSession();
		Post post  = session.find(Post.class,id);
		return post;
	}

	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Post> getByTitle(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Post obj) {
		// TODO Auto-generated method stub

	}

	public void delete(Post obj) {
		// TODO Auto-generated method stub

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
