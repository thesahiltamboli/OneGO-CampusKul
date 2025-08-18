package com.campuskul.user.operations.controller;

import com.campuskul.user.operations.dto.StudentRequestDTO;
import com.campuskul.user.operations.dto.StudentResponseDTO;
import com.campuskul.user.operations.model.Student;
import com.campuskul.user.operations.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<Map<String,Object>> getAllStudents() {
        Map<String,Object> response = new HashMap<>();
        List<StudentResponseDTO> students = studentService.getAllStudents();
        if(!students.isEmpty()){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", students);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching students");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Map<String,Object>> getStudentById(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        StudentResponseDTO student = studentService.getStudentById(id);
        if(student != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", student);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching students");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Map<String,Object>> addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        StudentResponseDTO student = studentService.addStudent(studentRequestDTO);
        if(student != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", student);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in adding students");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/editStudent/{id}")
    public ResponseEntity<Map<String,Object>> addStudent(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        StudentResponseDTO student = studentService.editStudent(id, studentRequestDTO);
        if(student != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", student);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in adding students");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
