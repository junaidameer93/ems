package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.projections.ProjectDetail;
import com.ems.projections.ProjectList;
import com.ems.service.api.ProjectService;

@Controller
@RequestMapping("web/project")
public class ProjectController {

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView loadProjectsList() {
		ModelAndView model = new ModelAndView();
		List<ProjectList> projects = service.findByIdIsNotNull();
		model.addObject("projects", projects);
		model.setViewName("projectlist");
		return model;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView loadProject(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		ProjectDetail project = service.findByIdEquals(id);
		model.addObject("project", project);
		model.setViewName("projectdetail");
		return model;
	}

}
