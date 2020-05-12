package com.cg.iter.diagnosticcenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.iter.diagnosticcenter.entity.DiagnosticCenter;

public interface DiagnosticCenterSevice {
ResponseEntity<DiagnosticCenter> addCenter(DiagnosticCenter center);
String removeCenter(String centerId);
boolean removeAll();
ResponseEntity<DiagnosticCenter> updateCenter(DiagnosticCenter center);
ResponseEntity<DiagnosticCenter> findCenter(String centerId);
List<DiagnosticCenter> getAllDiagnosticCentres();

}
