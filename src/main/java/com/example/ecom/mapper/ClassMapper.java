package com.example.ecom.mapper;

import com.example.ecom.DTO.ClassDTO;
import com.example.ecom.model.Class;
import java.util.stream.Collectors;

public class ClassMapper {

    public static ClassDTO toDTO(Class clazz) {
        ClassDTO dto = new ClassDTO();
        dto.setId(clazz.getId());
        dto.setName(clazz.getName());
        dto.setStudentIds(clazz.getStudents().stream().map(student -> student.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static Class toEntity(Class dto) {
        Class clazz = new Class();
        clazz.setId(dto.getId());
        clazz.setName(dto.getName());
        // Additional logic to set students if needed
        return clazz;
    }
}
