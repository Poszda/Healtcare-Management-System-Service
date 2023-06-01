package com.hmss.springbootserver.repositories;

import com.hmss.springbootserver.DTOs.appointments.MedicationDTO;
import com.hmss.springbootserver.entities.Medication;
import com.hmss.springbootserver.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {

    @Query("SELECT NEW com.hmss.springbootserver.DTOs.appointments.MedicationDTO(m.id, m.diagnostic.id, m.name, m.numberOfDays, m.dose) " +
            "FROM Medication m " +
            "WHERE m.diagnostic.id IN :diagnosticsIds")
    List<MedicationDTO> findByDiagnosticIdIn(@Param("diagnosticsIds") List<Long> diagnosticsIds);
}
