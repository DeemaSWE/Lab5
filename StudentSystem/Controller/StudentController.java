package com.example.lab5.StudentSystem.Controller;

import com.example.lab5.Api.ApiResponse;
import com.example.lab5.StudentSystem.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/name/{id}")
    public String getName(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s.getName();
            }
        }
        return "Student not found";
    }

    @GetMapping("/age/{id}")
    public Integer getAge(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s.getAge();
            }
        }
        return null;
    }

    @GetMapping("/college/degree/{id}")
    public String getDegree(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s.getDegree();
            }
        }
        return "Student not found";
    }

    @GetMapping("/study/status/{id}")
    public Boolean getStudyStatus(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s.isStudyStatus();
            }
        }
        return null;
    }

    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added");
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable String id, @RequestBody Student student) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.set(students.indexOf(s), student);
                return "Student updated";
            }
        }
        return "Student not found";
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                return new ApiResponse("Student deleted");
            }
        }
        return new ApiResponse("Student not found");
    }
}



