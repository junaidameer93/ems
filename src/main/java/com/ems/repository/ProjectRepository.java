package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Project;
import com.ems.projections.ProjectDetail;
import com.ems.projections.ProjectList;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<ProjectList> findByIdIsNotNull();
	ProjectDetail findByIdEquals(Integer id);

}
