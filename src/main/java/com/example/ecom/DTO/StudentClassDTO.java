package com.example.ecom.DTO;

import java.util.Set;

public class StudentClassDTO {


    private String studentName;
    private Long studentID;

    private Set<String> className;

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentID() {
        return studentID;
    }

    public Set<String> getClassName() {
        return className;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public void setClassName(Set<String> className) {
        this.className = className;
    }
}
