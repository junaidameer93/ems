package com.ems.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Project;
import com.ems.projections.ProjectDetail;
import com.ems.projections.ProjectList;
import com.ems.service.api.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectWebApi {

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addNewProject(@RequestBody Project project) {

		Project savedProject = service.addNewProject(project);
		if (savedProject == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<Project>(savedProject, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findProject(@PathVariable("id") Integer id) {

		ProjectDetail project = service.findByIdEquals(id);
		if (project == null) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProjectDetail>(project, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectList>> findAllProject() {
		List<ProjectList> projects = service.findByIdIsNotNull();
		return new ResponseEntity<List<ProjectList>>(projects, HttpStatus.OK);
	}
}
