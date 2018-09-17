package com.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	Optional<Technology> findByName(String name);
}
