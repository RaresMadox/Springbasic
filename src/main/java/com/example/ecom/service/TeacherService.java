package com.example.ecom.service;

import com.example.ecom.model.Student;
import com.example.ecom.model.Teacher;
import com.example.ecom.repository.StudentRepository;
import com.example.ecom.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // Save a new teacher
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


}
