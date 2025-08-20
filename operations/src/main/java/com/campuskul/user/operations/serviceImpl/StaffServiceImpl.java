package com.campuskul.user.operations.serviceImpl;

import com.campuskul.user.operations.dto.StaffRequestDTO;
import com.campuskul.user.operations.dto.StaffResponseDTO;
import com.campuskul.user.operations.model.College;
import com.campuskul.user.operations.model.Staff;
import com.campuskul.user.operations.model.User;
import com.campuskul.user.operations.repository.CollegeRepository;
import com.campuskul.user.operations.repository.StaffRepository;
import com.campuskul.user.operations.repository.UserRepository;
import com.campuskul.user.operations.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    private final CollegeRepository collegeRepository;

    private final UserRepository userRepository;

    @Override
    public List<StaffResponseDTO> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StaffResponseDTO addStaff(StaffRequestDTO dto) {
        User user =userRepository.findById(dto.getUserId()).orElseThrow(()-> new RuntimeException("User not found of Id: " + dto.getUserId()));
        College college = collegeRepository.findById(dto.getCollegeId()).orElseThrow(()->new RuntimeException("College not found of Id: "+ dto.getCollegeId()));
        Staff staff = Staff.builder()
                .userId(user)
                .collegeId(college) // assuming Long, adjust if it's a College object
                .name(dto.getName())
                .mobile(dto.getMobile())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .subject(dto.getSubject())
                .position(dto.getPosition())
                .status(dto.getStatus())
                .createdby(dto.getCreatedby())
                .createdate(LocalDateTime.now())
                .updatedate(LocalDateTime.now())
                .build();

        Staff saved = staffRepository.save(staff);

        return convertToDTO(saved);
    }

    @Override
    public StaffResponseDTO editStaff(Long id, StaffRequestDTO staffRequestDTO) {
        User user =userRepository.findById(staffRequestDTO.getUserId()).orElseThrow(()-> new RuntimeException("User not found of Id: " + staffRequestDTO.getUserId()));

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));

        staff.setUserId(user);
        staff.setName(staffRequestDTO.getName());
        College college = collegeRepository.findById(staffRequestDTO.getCollegeId()).orElseThrow(() -> new RuntimeException("College not found with id: " + staffRequestDTO.getCollegeId()));
        staff.setCollegeId(college);
        staff.setMobile(staffRequestDTO.getMobile());
        staff.setEmail(staffRequestDTO.getEmail());
        staff.setAddress(staffRequestDTO.getAddress());
        staff.setSubject(staffRequestDTO.getSubject());
        staff.setPosition(staffRequestDTO.getPosition());
        staff.setStatus(staffRequestDTO.getStatus());
        staff.setUpdatedby(staffRequestDTO.getUpdatedby());
        staff.setUpdatedate(LocalDateTime.now()); // set current timestamp

        Staff updatedStaff = staffRepository.save(staff);

        return convertToDTO(updatedStaff);
    }


    public StaffResponseDTO getByd(Long id){
        Staff staff = staffRepository.findById(id).orElseThrow(()-> new RuntimeException("Staff not found"));
        return convertToDTO(staff);
    }
    @Override
    public StaffResponseDTO deleteStaff(Long id){
        Staff staff = staffRepository.findById(id).orElseThrow(()-> new RuntimeException("Staff not found" + id));
        staff.setStatus("INACTIVE");
        Staff saved = staffRepository.save(staff);
        return convertToDTO(saved);
    }
    private StaffResponseDTO convertToDTO(Staff staff) {
        StaffResponseDTO dto = new StaffResponseDTO();
        dto.setId(staff.getId());
        dto.setUserId(staff.getUserId());
        dto.setName(staff.getName());
        dto.setCollege(staff.getCollegeId());
        dto.setMobile(staff.getMobile());
        dto.setEmail(staff.getEmail());
        dto.setAddress(staff.getAddress());
        dto.setSubject(staff.getSubject());
        dto.setPosition(staff.getPosition());
        dto.setStatus(staff.getStatus());
        dto.setCreatedby(staff.getCreatedby());
        dto.setCreatedate(staff.getCreatedate());
        dto.setUpdatedby(staff.getUpdatedby());
        dto.setUpdatedate(staff.getUpdatedate());
        return dto;
    }
}
