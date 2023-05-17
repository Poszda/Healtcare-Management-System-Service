package com.hmss.springbootserver.controllers;

import com.hmss.springbootserver.DTOs.SignUpRequestDTO;
import com.hmss.springbootserver.DTOs.speciality.SpecialityDTO;
import com.hmss.springbootserver.DTOs.speciality.SpecialityWithProceduresDTO;
import com.hmss.springbootserver.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/specialities")
public class SpecialityController {
    private final SpecialityService specialityService;

    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/getSpecialitiesWithProcedures")
    @CrossOrigin(origins = "*")
    public List<SpecialityWithProceduresDTO> getSpecialitiesWithProcedures(){
        return this.specialityService.getSpecialitiesWithProcedures();
    }

    @GetMapping("/getHospitalSpecialities/{hospitalId}")
    @CrossOrigin(origins = "*")
    public List<SpecialityDTO> getHospitalSpecialities(@PathVariable Long hospitalId){
        return this.specialityService.getHospitalSpecialities(hospitalId);
    }
}
