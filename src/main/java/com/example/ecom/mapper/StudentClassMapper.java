package com.example.ecom.mapper;

import com.example.ecom.DTO.StudentClassDTO;
import com.example.ecom.DTO.StudentDTO;
import com.example.ecom.model.Student;
import java.util.stream.Collectors;

public class StudentClassMapper {

    public static StudentClassDTO toDTO(Student student) {
        StudentClassDTO dto = new StudentClassDTO();
        dto.setStudentName(student.getName());
        dto.setStudentID(student.getId());
        dto.setClassName(student.getClassStudies().stream().map(clazz -> clazz.getName()).collect(Collectors.toSet()));
        return dto;
    }

    public static Student toEntity(StudentClassDTO dto) {
        Student student = new Student();
        student.setId(dto.getStudentID());
        student.setName(dto.getStudentName());
        // Additional logic to set classes if needed
        return student;
    }

}
