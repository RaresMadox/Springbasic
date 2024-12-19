package com.example.ecom.mapper;

import com.example.ecom.DTO.ClassDTO;
import com.example.ecom.model.ClassStudy;
import java.util.stream.Collectors;

public class ClassMapper {

    public static ClassDTO toDTO(ClassStudy clazz) {
        ClassDTO dto = new ClassDTO();
        dto.setId(clazz.getId());
        dto.setName(clazz.getName());
        dto.setStudentIds(clazz.getStudents().stream().map(student -> student.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static ClassStudy toEntity(ClassStudy dto) {
        ClassStudy clazz = new ClassStudy();
        clazz.setId(dto.getId());
        clazz.setName(dto.getName());
        // Additional logic to set students if needed
        return clazz;
    }
}
