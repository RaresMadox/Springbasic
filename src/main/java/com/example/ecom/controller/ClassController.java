package com.example.ecom.controller;

import com.example.ecom.DTO.ClassDTO;
import com.example.ecom.model.Class;
import com.example.ecom.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Get class by ID
    @GetMapping("/{id}")
    public Optional<ClassDTO> getClass(@PathVariable Long id) {
        return classService.getClass(id);
    }

    // Get all classes
    @GetMapping
    public List<ClassDTO> getAllClasses() {
        return classService.getAllClasses();
    }

    // Create a new class
    @PostMapping
    public ClassDTO createClass(@RequestBody Class clazz) {
        return classService.createClass(clazz);
    }

    // Delete class by ID
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
