package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ems.model.TeamMember;
import com.ems.repository.TeamMemberRepository;
import com.ems.service.api.TeamMemberService;

@Service
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {
	@Autowired
	private TeamMemberRepository repository;

	@Override
	public TeamMember addNewTeamMember(TeamMember teamMember) {
		try {
			TeamMember savedTeamMember = repository.save(teamMember);
			return savedTeamMember;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
