package com.example.ecom.service;

import com.example.ecom.DTO.ClassDTO;
import com.example.ecom.mapper.ClassMapper;
import com.example.ecom.model.Class;
import com.example.ecom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Get a class by ID
    public Optional<ClassDTO> getClass(Long id) {
        Optional<Class> clazz = classRepository.findById(id);
        return clazz.map(ClassMapper::toDTO);
    }

    // Create a new class
    public ClassDTO createClass(Class classDTO) {
        Class clazz = ClassMapper.toEntity(classDTO);
        clazz = classRepository.save(clazz);
        return ClassMapper.toDTO(clazz);
    }

    // Delete a class by ID
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    // Get all classes
    public List<ClassDTO> getAllClasses() {
        List<Class> classes = classRepository.findAll();
        return classes.stream().map(ClassMapper::toDTO).toList();
    }
}
