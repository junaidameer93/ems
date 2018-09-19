package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.EmpPost;

public interface EmpPostRepository extends JpaRepository<EmpPost, Integer> {

}
