package com.cg.iter.healthCare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.healthCare.entities.DiagnosticCentre;

@Repository
public interface DiagnosticCentreRepositories extends JpaRepository<DiagnosticCentre, String> {

	Optional<DiagnosticCentre> findById(String centerId);

	void deleteById(String centerId);
	
}
