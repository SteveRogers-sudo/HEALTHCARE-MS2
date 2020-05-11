package com.cg.iter.healthCare.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.iter.healthCare.entities.Test;
import com.cg.iter.healthCare.exceptions.RecordNotFoundException;
import com.cg.iter.healthCare.repositories.TestRepositories;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepositories dao;

////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Test> getAllTest() {
		return dao.findAll();
	}
////////////////////////////////////////////////////////////////////////////////////

	@Override
	public ResponseEntity<Test> addTest(Test test) {
		Optional<Test> find=dao.findById(test.getTestId());
		
		  try{
			  if(!find.isPresent()) { 
				  dao.save(test); 
				  return new
				  ResponseEntity<Test>(test, HttpStatus.OK); 
				  } 
			  else 
				  throw new RecordNotFoundException("Already exists"); 
			  } 
		  catch(RecordNotFoundException e){ 
			 return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND); 
		 }
	}
////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String removeTest(int testid) {
		Optional<Test> findById=dao.findById(testid);
		if(findById.isPresent()) {
			dao.deleteById(testid);
			return "test removed";
		}
		return "test not present";
	}
////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ResponseEntity<Test> updateTest(Test test) {
		 Optional<Test> findById = dao.findById(test.getTestId());
	        try {
	            if (findById.isPresent()) {
	                dao.save(test);
	                return new ResponseEntity<Test>(test, HttpStatus.OK);
	            	} 
	            else {
	                throw new RecordNotFoundException("Test not present");
	            }
	        }
	        catch (RecordNotFoundException e) {
	        	return new ResponseEntity<Test>(test, HttpStatus.NOT_FOUND);
	        }
	}
////////////////////////////////////////////////////////////////////////////////////

	@Override
	public ResponseEntity<Test> findTest(int testid) {
		Optional<Test> findById=dao.findById(testid);
		try {
			if(findById.isPresent()) {
				Test test=findById.get();
				return new ResponseEntity<Test>(test,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Test not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
