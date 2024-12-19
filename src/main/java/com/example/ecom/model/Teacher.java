package com.example.ecom.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(nullable = false)
    private String teacherName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    @JsonIgnore
    private ClassStudy classStudyJob;

}
