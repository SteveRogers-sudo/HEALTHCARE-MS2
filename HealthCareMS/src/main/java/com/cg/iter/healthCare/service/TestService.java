package com.cg.iter.healthCare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.healthCare.entities.Test;

public interface TestService {
	
	List<Test> getAllTest();
	/*
	 * 
	 */
	ResponseEntity<Test> addTest(Test test);
	/*
	 * 
	 */
	String removeTest(int testid);
	/*
	 * 
	 */
	ResponseEntity<Test> updateTest(Test test);
	/*
	 * 
	 */
	ResponseEntity<Test> findTest(int testid);
}
