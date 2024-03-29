package com.hmss.springbootserver.repositories;

import com.hmss.springbootserver.DTOs.doctor.DoctorWithUserAndSpecialityDTO;
import com.hmss.springbootserver.entities.Doctor;
import com.hmss.springbootserver.entities.User;
import com.hmss.springbootserver.utils.models.projections.DoctorProgramProjection;
import com.hmss.springbootserver.utils.models.projections.DoctorSearchProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT d.id as id,d.programStart as programStart,d.programEnd as programEnd FROM Doctor d " +
            "WHERE d.id IN :doctorsIds")
    List<DoctorProgramProjection> findDoctorsPrograms(@Param("doctorsIds") List<Long> doctorsIds);

    @Query("SELECT d from Doctor d " +
            "JOIN FETCH d.speciality s " +
            "JOIN FETCH d.user u " +
            "WHERE d.hospital.id =:hospitalId")
    List<Doctor> findHospitalDoctorsWithSpeciality(@Param("hospitalId") Long hospitalId);

    @Query("SELECT d.id as id, u.firstName as firstName, u.lastName as lastName, f.path as profileImage " +
            "FROM Doctor d " +
            "JOIN d.user u " +
            "JOIN u.fileMetadataList f "+
            "WHERE d.speciality.id = :specialityId AND " +
            "(:name IS NULL OR (u.firstName LIKE CONCAT('%', :name, '%') OR u.lastName LIKE CONCAT('%', :name, '%'))) AND " +
            "f.type = 'PROFILE_IMAGE'"
    )
    List<DoctorSearchProjection> findSearchedDoctors(@Param("name") String name, @Param("specialityId") Long specialityId);

    @Query("SELECT d FROM Doctor d JOIN FETCH d.user.fileMetadataList f WHERE d.id = :doctorId AND f.type = 'PROFILE_IMAGE'")
    Optional<Doctor> findDoctorAndProfileImage(@Param("doctorId") long doctorId);
}
