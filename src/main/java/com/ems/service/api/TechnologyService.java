package com.ems.service.api;

import java.util.Optional;

import com.ems.model.Technology;

public interface TechnologyService {

	Technology save(Technology tech);

	Optional<Technology> getById(Integer id);

	Optional<Technology> getByName(String name);

	void update(Technology tech);

	void delete(Technology tech);

	void delete(Integer id);

}
