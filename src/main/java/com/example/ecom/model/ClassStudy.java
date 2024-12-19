package com.example.ecom.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="class")
@ToString(exclude = {"classStudies","classStudyJob"})
@NoArgsConstructor
@AllArgsConstructor
public class ClassStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "classStudies",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classStudyJob", cascade = CascadeType.ALL)
    private Set<Teacher> teachers = new HashSet<>();



}
