package com.example.ecom.mapper;

import com.example.ecom.DTO.TeacherDTO;
import com.example.ecom.model.Teacher;

public class TeacherMapper {


    public static TeacherDTO toDTO(Teacher teacher)
    {

        TeacherDTO dto = new TeacherDTO();

        dto.setId(teacher.getTeacherId());
        dto.setName(teacher.getTeacherName());

        dto.setClassStudyJob(teacher.getClassStudyJob());
        return dto;
    }

    public static Teacher toEntity(TeacherDTO dto)
    {
        Teacher entity = new Teacher();

        entity.setTeacherId(dto.getId());
        entity.setTeacherName(dto.getName());
        entity.setClassStudyJob(dto.getClassStudyJob());

        return entity;


    }



}
