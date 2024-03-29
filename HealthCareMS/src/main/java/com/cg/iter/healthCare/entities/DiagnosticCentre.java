package com.cg.iter.healthCare.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Centre1")
public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String diagnosticCentreId;
	private String centreName;
	private String centreAddress;
	
	@OneToMany(mappedBy = "diagnosticCentre")
	private List<Test> listOfTests;
	
//	@OneToMany(mappedBy = "diagnosticCentre")
//	private List<Appointment> appointmentList;
	
	
	public String getDiagnosticCentreId() {
		return diagnosticCentreId;
	}
	public void setDiagnosticCentreId(String diagnosticCentreId) {
		this.diagnosticCentreId = diagnosticCentreId;
	}
	public String getCentreName() {
		return centreName;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	public String getCentreAddress() {
		return centreAddress;
	}
	public void setCentreAddress(String centreAddress) {
		this.centreAddress = centreAddress;
	}
	public List<Test> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}
	
//	public List<Appointment> getAppointmentList() {
//		return appointmentList;
//	}
//	public void setAppointmentList(List<Appointment> appointmentList) {
//		this.appointmentList = appointmentList;
//	}
//	@Override
//	public String toString() {
//		return "DiagnosticCentre [diagnosticCentreId=" + diagnosticCentreId + ", centreName=" + centreName
//				+ ", centreAddress=" + centreAddress + ", listOfTests=" + listOfTests + ", appointmentList="
//				+ appointmentList + "]";
//	}
	
	
}
