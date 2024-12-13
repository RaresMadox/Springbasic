package com.example.ecom.repository;

import com.example.ecom.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{
}
