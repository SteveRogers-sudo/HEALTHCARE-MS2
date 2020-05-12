package com.cg.iter.diagnosticcenter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.diagnosticcenter.entity.DiagnosticCenter;
@Repository
public interface DiagnosticCenterRepository extends CrudRepository<DiagnosticCenter, String>{

}
