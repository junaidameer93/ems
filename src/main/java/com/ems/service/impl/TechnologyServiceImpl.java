package com.ems.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Technology;
import com.ems.repository.TechnologyRepository;
import com.ems.service.api.TechnologyService;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

	Logger logger = LoggerFactory.getLogger(TechnologyServiceImpl.class);

	@Autowired
	private TechnologyRepository repository;

	public Technology save(Technology tech) {
		logger.info("save method started for Technology: " + tech.toString());
		try {
			Technology savedTechnology = repository.save(tech);

			logger.info("Successfully save Technology");
			return savedTechnology;
		} catch (Exception e) {
			logger.error("Error while saving Technology");
			logger.error(e.getMessage());
		}

		return null;

	}

	public Optional<Technology> getById(Integer id) {
		return repository.findById(id);
	}

	public Optional<Technology> getByName(String name) {
		return repository.findByName(name);
	}

	public void update(Technology tech) {
		repository.saveAndFlush(tech);

	}

	public void delete(Technology tech) {
		repository.delete(tech);

	}

	public void delete(Integer id) {
		repository.deleteById(id);

	}

}
