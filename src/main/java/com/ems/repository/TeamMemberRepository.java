package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

}
