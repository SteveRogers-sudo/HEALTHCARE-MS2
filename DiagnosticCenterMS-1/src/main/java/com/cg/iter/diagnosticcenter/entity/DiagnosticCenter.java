package com.cg.iter.diagnosticcenter.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;

@Entity
@Table(name = "Center_Table")

public class DiagnosticCenter {
	@Id
	private String centerId;
	private String centerName;

	public DiagnosticCenter(String centerId, String centerName) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
	}

	public DiagnosticCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

//@OneToMany(mappedBy = "diagnosticCentre")
//private List<Test> listOfTests;

//@OneToMany(mappedBy = "diagnosticCentre")
//private List<Appointment> appointmentList;

}
