package com.campuskul.user.operations.serviceImpl;

import com.campuskul.user.operations.dto.AlumniRequestDTO;
import com.campuskul.user.operations.dto.AlumniResponseDTO;
import com.campuskul.user.operations.model.Alumni;
import com.campuskul.user.operations.model.College;
import com.campuskul.user.operations.repository.AlumniRepository;
import com.campuskul.user.operations.repository.CollegeRepository;
import com.campuskul.user.operations.service.AlumniService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumniServiceImpl implements AlumniService {

    private final AlumniRepository alumniRepository;

    private final CollegeRepository collegeRepository;
    @Override
    public List<AlumniResponseDTO> getAllAlumines() {
        List<Alumni> alumniList = alumniRepository.findAll();
        return alumniList.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }


    public AlumniResponseDTO addAlumni(AlumniRequestDTO requestDTO) {
        College college = collegeRepository.findById(requestDTO.getCollegeId()).orElseThrow(()-> new RuntimeException("College not found"+ requestDTO.getCollegeId()));
        Alumni alumni = Alumni.builder()
                .userId(requestDTO.getUserId())
                .alumniName(requestDTO.getAlumniName())
                .collegeId(college)
                .alumniMobile(requestDTO.getAlumniMobile())
                .alumniEmail(requestDTO.getAlumniEmail())
                .alumniAddr(requestDTO.getAlumniAddr())
                .alumniYear(requestDTO.getAlumniYear())
                .university(requestDTO.getUniversity())
                .pincode(requestDTO.getPincode())
                .about(requestDTO.getAbout())
                .companyName(requestDTO.getCompanyName())
                .profilepic(requestDTO.getProfilepic())
                .isMentor(requestDTO.getIsMentor())
                .status(requestDTO.getStatus())
                .createdby(requestDTO.getCreatedby())
                .createddate(LocalDateTime.now())
                .updatedby(requestDTO.getUpdatedby())
                .updatedate(LocalDateTime.now())
                .build();

        Alumni savedAlumni = alumniRepository.save(alumni);

        return mapToResponseDTO(savedAlumni);
    }


    public AlumniResponseDTO editAlumni(Long id, AlumniRequestDTO requestDTO) {
        Alumni alumni = alumniRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + id));

        College college = collegeRepository.findById(requestDTO.getCollegeId()).orElseThrow(()-> new RuntimeException("College not found"+ requestDTO.getCollegeId()));

        alumni.setUserId(requestDTO.getUserId());
        alumni.setAlumniName(requestDTO.getAlumniName());
        alumni.setCollegeId(college);
        alumni.setAlumniMobile(requestDTO.getAlumniMobile());
        alumni.setAlumniEmail(requestDTO.getAlumniEmail());
        alumni.setAlumniAddr(requestDTO.getAlumniAddr());
        alumni.setAlumniYear(requestDTO.getAlumniYear());
        alumni.setUniversity(requestDTO.getUniversity());
        alumni.setPincode(requestDTO.getPincode());
        alumni.setAbout(requestDTO.getAbout());
        alumni.setCompanyName(requestDTO.getCompanyName());
        alumni.setProfilepic(requestDTO.getProfilepic());
        alumni.setIsMentor(requestDTO.getIsMentor());
        alumni.setStatus(requestDTO.getStatus());
        alumni.setCreatedby(requestDTO.getCreatedby());
        alumni.setCreateddate(LocalDateTime.now());
        alumni.setUpdatedby(requestDTO.getUpdatedby());
        alumni.setUpdatedate(LocalDateTime.now());

        Alumni updatedAlumni = alumniRepository.save(alumni);

        return mapToResponseDTO(updatedAlumni);
    }


    @Override
    public AlumniResponseDTO getAlumniById(Long id) {
        Alumni alumni = alumniRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + id));
        return
                mapToResponseDTO(alumni);
    }

    public AlumniResponseDTO deleteAlumni(Long id) {
        Alumni alumni = alumniRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumni not found with id: " + id));
        alumni.setStatus("INACTIVE");
        Alumni saved = alumniRepository.save(alumni);
        return mapToResponseDTO(saved);
    }

    private AlumniResponseDTO mapToResponseDTO(Alumni alumni) {
        AlumniResponseDTO dto = new AlumniResponseDTO();
        dto.setId(alumni.getId());
        dto.setUserId(alumni.getUserId());
        dto.setAlumniName(alumni.getAlumniName());
        dto.setCollegeId(alumni.getCollegeId());
        dto.setAlumniMobile(alumni.getAlumniMobile());
        dto.setAlumniEmail(alumni.getAlumniEmail());
        dto.setAlumniAddr(alumni.getAlumniAddr());
        dto.setAlumniYear(alumni.getAlumniYear());
        dto.setUniversity(alumni.getUniversity());
        dto.setPincode(alumni.getPincode());
        dto.setAbout(alumni.getAbout());
        dto.setCompanyName(alumni.getCompanyName());
        dto.setProfilepic(alumni.getProfilepic());
        dto.setIsMentor(alumni.getIsMentor());
        dto.setStatus(alumni.getStatus());
        dto.setCreatedby(alumni.getCreatedby());
        dto.setCreateddate(alumni.getCreateddate());
        dto.setUpdatedby(alumni.getUpdatedby());
        dto.setUpdatedate(alumni.getUpdatedate());
        return dto;
    }


}
