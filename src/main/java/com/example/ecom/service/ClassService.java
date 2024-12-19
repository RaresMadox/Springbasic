package com.example.ecom.service;

import com.example.ecom.DTO.ClassDTO;
import com.example.ecom.mapper.ClassMapper;
import com.example.ecom.model.ClassStudy;
import com.example.ecom.model.Teacher;
import com.example.ecom.repository.ClassRepository;
import com.example.ecom.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    // Get a class by ID
    public Optional<ClassDTO> getClass(Long id) {
        Optional<ClassStudy> clazz = classRepository.findById(id);
        return clazz.map(ClassMapper::toDTO);
    }

    // Create a new class
    public ClassDTO createClass(ClassStudy classStudyDTO) {
        ClassStudy clazz = ClassMapper.toEntity(classStudyDTO);
        clazz = classRepository.save(clazz);
        return ClassMapper.toDTO(clazz);
    }

    // Delete a class by ID
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    // Get all classes
    public List<ClassDTO> getAllClasses() {
        List<ClassStudy> classStudies = classRepository.findAll();
        return classStudies.stream().map(ClassMapper::toDTO).toList();
    }

    public ClassDTO addTeacherToClass(Long teacherID,Long classID)
    {
        ClassStudy classStudy = classRepository.getReferenceById(classID);
        classStudy.getTeachers().add(teacherRepository.getReferenceById(teacherID));
        Teacher teacher = teacherRepository.getReferenceById(teacherID);
        teacher.setClassStudyJob(classStudy);

        classRepository.save(classStudy);
        teacherRepository.save(teacher);
        return ClassMapper.toDTO(classStudy);
    }
}
