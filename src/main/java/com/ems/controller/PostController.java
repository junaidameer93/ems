package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.model.Post;
import com.ems.service.api.PostService;

@Controller
@RequestMapping("web/post")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView loadPost() {
		ModelAndView model = new ModelAndView();
		List<Post> posts = postService.getAll();
		model.addObject("posts", posts);
		model.setViewName("post");
		return model;
	}

}
