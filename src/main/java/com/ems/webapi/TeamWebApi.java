package com.ems.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Team;
import com.ems.service.api.TeamService;

@RestController
@RequestMapping("team")
public class TeamWebApi {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addNewTeam(@RequestBody Team team) {
		Team savedTeam = teamService.addNewTeam(team);
		if (savedTeam == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<Team>(savedTeam, HttpStatus.OK);
	}

}
