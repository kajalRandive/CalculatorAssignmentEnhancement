package com.assignment2.enhancement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.enhancement.entity.RequestResponseEntity;

@Repository("calDao")
	public interface CalculatorDao extends JpaRepository<RequestResponseEntity, Long> {
	}


