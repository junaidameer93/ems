package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Team;
import com.ems.repository.TeamRepository;
import com.ems.service.api.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository repository;

	@Override
	public Team addNewTeam(Team team) {

		try {
			Team savedTeam = repository.save(team);
			return savedTeam;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
