package com.cg.iter.healthCare.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.healthCare.entities.Appointment;

@Repository
public interface AppointmentRepositories extends JpaRepository<Appointment, Integer>{

}
