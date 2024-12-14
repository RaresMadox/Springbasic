package com.example.ecom.service;

import com.example.ecom.DTO.StudentDTO;
import com.example.ecom.mapper.StudentMapper;
import com.example.ecom.model.Student;
import com.example.ecom.model.Class;
import com.example.ecom.repository.StudentRepository;
import com.example.ecom.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    // Get a student by ID
    public Optional<StudentDTO> getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(StudentMapper::toDTO);
    }

    // Create a new student
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return StudentMapper.toDTO(student);
    }

    // Delete a student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Get all students
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::toDTO).toList();
    }

    // Add a class to a student
    @Transactional
    public void addClassToStudent(Long studentId, Long classId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Class clazz = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        // Avoid ConcurrentModificationException
        Set<Class> classes = new HashSet<>(student.getClasses());
        classes.add(clazz); // Add the new class
        student.setClasses(classes); // Update the student's classes

        // Ensure bidirectional relationship is maintained
        clazz.getStudents().add(student);

        // Save changes
        classRepository.save(clazz);
        studentRepository.save(student);
    }

    // Get all classes a student is enrolled in
    public Set<Class> getClassesOfStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(Student::getClasses).orElse(new HashSet<>());
    }
}
