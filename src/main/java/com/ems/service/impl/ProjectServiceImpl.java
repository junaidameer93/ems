package com.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Project;
import com.ems.projections.ProjectDetail;
import com.ems.projections.ProjectList;
import com.ems.repository.ProjectRepository;
import com.ems.service.api.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

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

	@Override
	public Project findById(Integer id) {
		Optional<Project> project = repository.findById(id);
		if (project.isPresent())
			return project.get();
		return null;
	}

	@Override
	public List<Project> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ProjectList> findByIdIsNotNull() {
		return repository.findByIdIsNotNull();
	}

	@Override
	public ProjectDetail findByIdEquals(Integer id) {
		return repository.findByIdEquals(id);
	}

}
