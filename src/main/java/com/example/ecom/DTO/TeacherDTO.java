package com.example.ecom.DTO;


import com.example.ecom.model.ClassStudy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    private Long id;
    private String name;
    private ClassStudy classStudyJob;


}
