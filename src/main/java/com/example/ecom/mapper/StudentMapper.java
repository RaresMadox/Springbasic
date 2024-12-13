package com.example.ecom.mapper;

import com.example.ecom.DTO.StudentDTO;
import com.example.ecom.model.Student;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setClassIds(student.getClasses().stream().map(clazz -> clazz.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        // Additional logic to set classes if needed
        return student;
    }
}
