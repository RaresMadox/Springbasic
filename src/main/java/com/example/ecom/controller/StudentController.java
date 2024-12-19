package com.example.ecom.controller;

import com.example.ecom.DTO.StudentClassDTO;
import com.example.ecom.DTO.StudentDTO;
import com.example.ecom.model.ClassStudy;
import com.example.ecom.service.StudentService;
import com.example.ecom.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    // Get student by ID
    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Get all students
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Create a new student
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Add a class to a student
    @PostMapping("/{studentId}/classes/{classId}")
    public void addClassToStudent(@PathVariable Long studentId, @PathVariable Long classId) {
        studentService.addClassToStudent(studentId, classId);
    }

    // Get all classes for a student
    @GetMapping("/{id}/classes")
    public Set<ClassStudy> getClassesOfStudent(@PathVariable Long id) {
        return studentService.getClassesOfStudent(id);
    }

    @GetMapping("/{id}/studentClass")
    public List<StudentClassDTO> getAllClasses(@PathVariable Long id)
    {
        return studentService.getAllClasses(id);
    }

}


