package com.campuskul.user.operations.serviceImpl;


import com.campuskul.user.operations.dto.StudentRequestDTO;
import com.campuskul.user.operations.dto.StudentResponseDTO;
import com.campuskul.user.operations.model.Student;
import com.campuskul.user.operations.repository.StudentRepository;
import com.campuskul.user.operations.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student student = Student.builder()
                .studentName(dto.getStudentName())
                .userId(dto.getUserId())
                .collegeId(dto.getCollegeId())
                .studentMobile(dto.getStudentMobile())
                .studentEmail(dto.getStudentEmail())
                .studentAddr(dto.getStudentAddr())
                .studentDept(dto.getStudentDept())
                .studentYear(dto.getStudentYear())
                .passingYear(dto.getPassingYear())
                .university(dto.getUniversity())
                .degree(dto.getDegree())
                .countryId(dto.getCountryId())
                .stateId(dto.getStateId())
                .cityId(dto.getCityId())
                .pincode(dto.getPincode())
                .about(dto.getAbout())
                .motherName(dto.getMotherName())
                .profilepic(dto.getProfilepic())
                .status(dto.getStatus())
                .createdby(dto.getCreatedby())
                .createdate(LocalDateTime.now())
                .build();

        Student saved = studentRepository.save(student);

        return convertToDTO(saved);
    }

    public StudentResponseDTO editStudent(Long id,StudentRequestDTO dto) {
        Student student = studentRepository.findById(id).orElse(null).builder()
                .studentName(dto.getStudentName())
                .userId(dto.getUserId())
                .collegeId(dto.getCollegeId())
                .studentMobile(dto.getStudentMobile())
                .studentEmail(dto.getStudentEmail())
                .studentAddr(dto.getStudentAddr())
                .studentDept(dto.getStudentDept())
                .studentYear(dto.getStudentYear())
                .passingYear(dto.getPassingYear())
                .university(dto.getUniversity())
                .degree(dto.getDegree())
                .countryId(dto.getCountryId())
                .stateId(dto.getStateId())
                .cityId(dto.getCityId())
                .pincode(dto.getPincode())
                .about(dto.getAbout())
                .motherName(dto.getMotherName())
                .profilepic(dto.getProfilepic())
                .status(dto.getStatus())
                .createdby(dto.getCreatedby())
                .createdate(LocalDateTime.now())
                .build();

        Student saved = studentRepository.save(student);

        return convertToDTO(saved);
    }
    private StudentResponseDTO convertToDTO(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .userId(student.getUserId())
                .studentName(student.getStudentName())
                .collegeId(student.getCollegeId())
                .studentMobile(student.getStudentMobile())
                .studentEmail(student.getStudentEmail())
                .studentAddr(student.getStudentAddr())
                .studentDept(student.getStudentDept())
                .studentYear(student.getStudentYear())
                .passingYear(student.getPassingYear())
                .university(student.getUniversity())
                .degree(student.getDegree())
                .countryId(student.getCountryId())
                .stateId(student.getStateId())
                .cityId(student.getCityId())
                .pincode(student.getPincode())
                .about(student.getAbout())
                .motherName(student.getMotherName())
                .profilepic(student.getProfilepic())
                .status(student.getStatus())
                .createdby(student.getCreatedby())
                .createdate(student.getCreatedate())
                .updatedby(student.getUpdatedby())
                .updatedate(student.getUpdatedate())
                .build();
    }


}
