package com.ems.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.EmpPost;
import com.ems.model.TeamMember;
import com.ems.service.api.EmpPostService;

@RestController
@RequestMapping("/emppost")
public class EmpPostWebApi {
	@Autowired
	private EmpPostService service;
	
	@RequestMapping(value="",method=RequestMethod.POST) 
	public ResponseEntity<?> addEmpPost(@RequestBody EmpPost empPost) {
		EmpPost savedEmpPost = service.addEmpPost(empPost);
		if (savedEmpPost == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<EmpPost>(savedEmpPost, HttpStatus.OK);
	}

}
