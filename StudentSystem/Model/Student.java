package com.example.lab5.StudentSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    private String id;
    private String name;
    private int age;
    private String degree;
    private boolean studyStatus;
}
