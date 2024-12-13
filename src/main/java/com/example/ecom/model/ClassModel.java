package com.example.ecom.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "ClassTable")
@NoArgsConstructor
@AllArgsConstructor
public class ClassModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classID;

    private String className;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    Set<Student> enrolledStudents = new HashSet<>();

}
