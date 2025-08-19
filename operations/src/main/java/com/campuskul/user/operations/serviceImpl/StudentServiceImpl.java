package com.campuskul.user.operations.serviceImpl;


import com.campuskul.user.operations.dto.StudentRequestDTO;
import com.campuskul.user.operations.dto.StudentResponseDTO;
import com.campuskul.user.operations.model.College;
import com.campuskul.user.operations.model.Student;
import com.campuskul.user.operations.repository.CollegeRepository;
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

    private final CollegeRepository collegeRepository;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
// Todo : Pagination in near future
    public StudentResponseDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        College college = collegeRepository.findById(dto.getCollegeId()).get();
        Student student = Student.builder()
                .studentName(dto.getStudentName())
                .userId(dto.getUserId())
                .collegeId(college)
                .studentMobile(dto.getStudentMobile())
                .studentEmail(dto.getStudentEmail())
                .studentAddr(dto.getStudentAddr())
                .studentDept(dto.getStudentDept())
                .studentYear(dto.getStudentYear())
                .passingYear(dto.getPassingYear())
                .university(dto.getUniversity())
                .degree(dto.getDegree())
                .pincode(dto.getPincode())
                .about(dto.getAbout())
                .motherName(dto.getMotherName())
                .profilepic(dto.getProfilepic())
                .status(dto.getStatus())
                .createdby(dto.getCreatedby())
                .createdate(LocalDateTime.now())
                .updatedate(LocalDateTime.now())
                .build();

        Student saved = studentRepository.save(student);

        return convertToDTO(saved);
    }

    public StudentResponseDTO editStudent(Long id, StudentRequestDTO dto) {
        // Fetch existing student
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Fetch associated college
        College college = collegeRepository.findById(dto.getCollegeId())
                .orElseThrow(() -> new RuntimeException("College not found"));

        // Update fields
        student.setStudentName(dto.getStudentName());
        student.setUserId(dto.getUserId());
        student.setCollegeId(college);
        student.setStudentMobile(dto.getStudentMobile());
        student.setStudentEmail(dto.getStudentEmail());
        student.setStudentAddr(dto.getStudentAddr());
        student.setStudentDept(dto.getStudentDept());
        student.setStudentYear(dto.getStudentYear());
        student.setPassingYear(dto.getPassingYear());
        student.setUniversity(dto.getUniversity());
        student.setDegree(dto.getDegree());
        student.setPincode(dto.getPincode());
        student.setAbout(dto.getAbout());
        student.setMotherName(dto.getMotherName());
        student.setProfilepic(dto.getProfilepic());
        student.setStatus(dto.getStatus());
        student.setCreatedby(dto.getCreatedby());
        student.setCreatedate(student.getCreatedate());
        student.setUpdatedate(LocalDateTime.now());

        Student saved = studentRepository.save(student);

        return convertToDTO(saved);
    }

    public StudentResponseDTO deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found of Id" + id));
        student.setStatus("INACTIVE");
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
