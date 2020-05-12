package com.cg.iter.diagnosticcenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.diagnosticcenter.entity.DiagnosticCenter;
import com.cg.iter.diagnosticcenter.exception.RecordNotFoundException;
import com.cg.iter.diagnosticcenter.repository.DiagnosticCenterRepository;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterSevice {
	@Autowired
DiagnosticCenterRepository repo;// to create an instance of repository
/*
 * @Override public boolean addCenter( DiagnosticCenter center) { String
 * centerId="CEN"+repo.count(); center.setCenterId(centerId); repo.save(center);
 * return true;
 * 
 * }
 */

@Override
public String removeCenter(String centerId) {
	
	Optional<DiagnosticCenter> findById=repo.findById(centerId);
	String success="center deleted";
	if(findById.isPresent()) {
	repo.deleteById(centerId);;
	return success;
	}
	return "centre not deleted";
}



	@Override
	public boolean removeAll() {
		repo.deleteAll();
		return true;
	}

	@Override
	public List<DiagnosticCenter> getAllDiagnosticCentres() {
	return (List<DiagnosticCenter>) repo.findAll();
		
	}

	@Override
	public ResponseEntity<DiagnosticCenter> addCenter(DiagnosticCenter center) {
		String centerId="CEN"+repo.count();
		center.setCenterId(centerId);
		Optional<DiagnosticCenter> find=repo.findById(center.getCenterId());
		
		  try{
			  if(!find.isPresent()) { 
				  repo.save(center); 
				  return new ResponseEntity<DiagnosticCenter>(center, HttpStatus.OK); 
				  } 
			  else 
				  throw new RecordNotFoundException("Already exists"); 
			  } 
		  catch(RecordNotFoundException e){ 
			 return new ResponseEntity<DiagnosticCenter>(center, HttpStatus.NOT_FOUND); 
		 }
		
	}

	@Override
	public ResponseEntity<DiagnosticCenter> updateCenter(DiagnosticCenter center) {
		String centerId="CEN"+repo.count();
		center.setCenterId(centerId);
		 Optional<DiagnosticCenter> findById = repo.findById(center.getCenterId());
	        try {
	            if (findById.isPresent()) {
	                repo.save(center);
	                return new ResponseEntity<DiagnosticCenter>(center, HttpStatus.OK);
	            	} 
	            else {
	                throw new RecordNotFoundException("Center not present");
	            }
	        }
	        catch (RecordNotFoundException e) {
	        	return new ResponseEntity<DiagnosticCenter>(center, HttpStatus.NOT_FOUND);
	        }
	}

	@Override
	public ResponseEntity<DiagnosticCenter> findCenter(String centerId) {
		
		Optional<DiagnosticCenter> findById=repo.findById(centerId);
		try {
			if(findById.isPresent()) {
				DiagnosticCenter center=findById.get();
				return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Center not found");
		}
		catch(RecordNotFoundException message) {
			return new ResponseEntity(message.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	

}









/*
 * public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(@RequestBody
 * DiagnosticCentre diagnosticCentre2) { Optional<DiagnosticCentre>
 * findById=dao.findById(diagnosticCentre2.getDiagnosticCentreId()); try{
 * if(!findById.isPresent()) { dao.save(diagnosticCentre2); return new
 * ResponseEntity<DiagnosticCentre>(diagnosticCentre2, HttpStatus.OK); } else
 * throw new RecordNotFoundException("Diagnostic Centre already present..."); }
 * catch(RecordNotFoundException e){ return new
 * ResponseEntity<DiagnosticCentre>(diagnosticCentre2, HttpStatus.NOT_FOUND); }
 * }
 * 
 * @DeleteMapping("/deleteDiagnosticCentre/{id}") public String
 * removeDiagnosticCentre(@PathVariable("id") int diagnosticCentreid) {
 * Optional<DiagnosticCentre> findById=dao.findById(diagnosticCentreid);
 * if(findById.isPresent()) { dao.deleteById(diagnosticCentreid); return
 * "Diagnostic Centre removed"; }
 * 
 * return "Diagnostic Centre not present"; }
 * 
 * @PutMapping("/updateDiagnosticCentre") public String
 * updateDiagnosticCentre(@RequestBody DiagnosticCentre diagnosticCentre) {
 * Optional<DiagnosticCentre>
 * findById=dao.findById(diagnosticCentre.getDiagnosticCentreId());
 * if(findById.isPresent()) { dao.save(diagnosticCentre); return
 * "Diagnostic Centre updated"; }
 * 
 * return "Diagnostic Centre not present"; }
 * 
 * 
 */


