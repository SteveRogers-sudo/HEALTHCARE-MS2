package com.cg.iter.diagnosticcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.diagnosticcenter.entity.DiagnosticCenter;
import com.cg.iter.diagnosticcenter.exception.RecordNotFoundException;
import com.cg.iter.diagnosticcenter.service.DiagnosticCenterSevice;

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {
	@Autowired
	DiagnosticCenterSevice diagnosticCenterSevice;

	@GetMapping("/getAll")
	List<DiagnosticCenter> getAllDiagnosticCentres() {
		return diagnosticCenterSevice.getAllDiagnosticCentres();
	}

	@PostMapping("/addCenter")

	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center) {
		
		
		return 	diagnosticCenterSevice.addCenter(center);
			
	
		
		
	}

	@PostMapping("/removeCenter")
	String removeCenter(@RequestParam String centerId) {
		
		return diagnosticCenterSevice.removeCenter(centerId);
		

	}

}
