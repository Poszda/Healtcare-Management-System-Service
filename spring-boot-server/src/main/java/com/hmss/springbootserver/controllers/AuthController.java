package com.hmss.springbootserver.controllers;

import com.hmss.springbootserver.DTOs.LoginRequestDTO;
import com.hmss.springbootserver.entities.B;
import com.hmss.springbootserver.entities.Patient;
import com.hmss.springbootserver.entities.User;
import com.hmss.springbootserver.repositories.BRepo;
import com.hmss.springbootserver.repositories.PatientRepository;
import com.hmss.springbootserver.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    private final BRepo bRepo;

    @Autowired
    public AuthController(UserRepository userRepository, PatientRepository patientRepository,BRepo bRepo) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.bRepo = bRepo;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        var x = patientRepository.findAll();
        return x;
    }

    @PostMapping("/login")
    @Transactional
    public Object login(@RequestBody LoginRequestDTO loginRequest){
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(user != null){
            if(user.getType() == 1){
                return user.getAdmin();
            }
            if(user.getType() == 2){
                user.getPatient();
            }
            if(user.getType() == 3){
                var x = user.getPatient();
                return x;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/b")
    @Transactional
    public B getB(){
        //var y=bRepo.findAll();
        var x = bRepo.findByName("un nume");
        //x.getA();
        x.setA(null);
        return x;
    }
}
