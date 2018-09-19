package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.EmpPost;
import com.ems.model.TeamMember;
import com.ems.repository.EmpPostRepository;
import com.ems.service.api.EmpPostService;

@Service
@Transactional
public class EmpPostServiceImpl implements EmpPostService {

	@Autowired
	private EmpPostRepository repository;
	
	public EmpPost addEmpPost(EmpPost empPost) {
		try {
			EmpPost savedEmpPost = repository.save(empPost);
			return savedEmpPost;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
