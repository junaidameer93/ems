package com.ems.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.TeamMember;
import com.ems.service.api.TeamMemberService;

@RestController
@RequestMapping("teammember")
public class TeamMemberWebApi {

	@Autowired
	private TeamMemberService service;
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addTeamMember(@RequestBody TeamMember teamMember) {
		TeamMember savedTeamMember = service.addNewTeamMember(teamMember);
		if (savedTeamMember == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<TeamMember>(savedTeamMember, HttpStatus.OK);
	}
}
