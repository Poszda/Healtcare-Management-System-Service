package com.hmss.springbootserver.mappers;

import com.hmss.springbootserver.DTOs.user.AdminLoginDTO;
import com.hmss.springbootserver.DTOs.user.DoctorLoginDTO;
import com.hmss.springbootserver.DTOs.user.PatientLoginDTO;
import com.hmss.springbootserver.DTOs.user.UserDTO;
import com.hmss.springbootserver.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Named("UserMapper")
@Mapper(uses = {PatientMapper.class,DoctorMapper.class, AdminMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named("toUserDTO")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "admin.id", target = "adminId")
    @Mapping(source = "patient.id", target = "patientId")
    UserDTO toUserDTO(User user);

    @Named("UserToPatientLoginDTO")
    @Mapping(target = "patient" ,qualifiedByName = "toPatientDTO")
    PatientLoginDTO UserToPatientLoginDTO(User user);

    @Named("UserToDoctorLoginDTO")
    @Mapping(target = "doctor" ,qualifiedByName = "toDoctorDTO")
    DoctorLoginDTO UserToDoctorLoginDTO(User user);

    @Named("UserToAdminLoginDTO")
    @Mapping(target = "admin" ,qualifiedByName = "toAdminDTO")
    AdminLoginDTO UserToAdminLoginDTO(User user);

}
