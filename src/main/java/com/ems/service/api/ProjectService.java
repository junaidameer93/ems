package com.ems.service.api;

import java.util.List;

import com.ems.model.Project;
import com.ems.projections.ProjectDetail;
import com.ems.projections.ProjectList;

public interface ProjectService {

	Project addNewProject(Project project);

	Project findById(Integer id);

	List<Project> findAll();
	
	List<ProjectList> findByIdIsNotNull();
	
	ProjectDetail findByIdEquals(Integer id);

}
