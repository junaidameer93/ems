package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
