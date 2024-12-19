package com.example.ecom.repository;

import com.example.ecom.model.ClassStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassStudy,Long> {
}
