package com.campuskul.user.operations.service;


import com.campuskul.user.operations.dto.StudentRequestDTO;
import com.campuskul.user.operations.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO);

    StudentResponseDTO editStudent(Long id, StudentRequestDTO studentRequestDTO);

    StudentResponseDTO deleteStudent(Long id);
}
