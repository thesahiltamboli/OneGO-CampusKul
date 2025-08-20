package com.campuskul.user.operations.service;

import com.campuskul.user.operations.dto.StaffRequestDTO;
import com.campuskul.user.operations.dto.StaffResponseDTO;

import java.util.List;

public interface StaffService {
    List<StaffResponseDTO> getAllStaff();

    StaffResponseDTO addStaff(StaffRequestDTO dto);

    StaffResponseDTO editStaff(Long id, StaffRequestDTO dto);

    StaffResponseDTO deleteStaff(Long id);

    StaffResponseDTO getByd(Long id);
}
