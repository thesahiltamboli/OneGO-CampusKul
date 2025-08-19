package com.campuskul.user.operations.service;


import com.campuskul.user.operations.dto.AlumniRequestDTO;
import com.campuskul.user.operations.dto.AlumniResponseDTO;
import java.util.List;

public interface AlumniService {
    List<AlumniResponseDTO> getAllAlumines();

    AlumniResponseDTO addAlumni(AlumniRequestDTO dto);

    AlumniResponseDTO editAlumni(Long id, AlumniRequestDTO dto);

    AlumniResponseDTO deleteAlumni(Long id);

}
