package com.ems.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Project;
import com.ems.service.api.ProjectServcie;

@RestController
@RequestMapping("project")
public class ProjectWebApi {

	@Autowired
	private ProjectServcie service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addNewProject(@RequestBody Project project) {

		Project savedProject = service.addNewProject(project);
		if (savedProject == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<Project>(savedProject, HttpStatus.OK);
	}

}
