package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Project;
import com.ems.repository.ProjectRepository;
import com.ems.service.api.ProjectServcie;

@Service
@Transactional
public class ProjectServcieImpl implements ProjectServcie {

	@Autowired
	private ProjectRepository repository;

	@Override
	public Project addNewProject(Project project) {

		try {
			Project savedProject = repository.save(project);
			return savedProject;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
