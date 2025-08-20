package com.campuskul.user.operations.service;


import com.campuskul.user.operations.dto.CollegeRequestDTO;
import com.campuskul.user.operations.dto.CollegeResponseDTO;

import java.io.IOException;
import java.util.List;

public interface CollegeService {
    List<CollegeResponseDTO> getAllColleges();
    CollegeResponseDTO getCollegeById(Long id);

    CollegeResponseDTO addCollege(CollegeRequestDTO collegeRequestDTO) throws IOException;

    CollegeResponseDTO editCollege(Long id, CollegeRequestDTO collegeRequestDTO) throws IOException;
    CollegeResponseDTO deleteCollege(Long id) ;
}
