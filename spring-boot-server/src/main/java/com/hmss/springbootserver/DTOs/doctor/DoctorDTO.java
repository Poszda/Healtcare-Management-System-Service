package com.hmss.springbootserver.DTOs.doctor;

public class DoctorDTO {
    private Long id;
    private String university;
    private String description;
    private Long userId;
    private Long hospitalId;

    public DoctorDTO(Long id, String university, String description, Long userId, Long hospitalId) {
        this.id = id;
        this.university = university;
        this.description = description;
        this.userId = userId;
        this.hospitalId = hospitalId;
    }

    public DoctorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
