package com.campuskul.user.operations.dto;

import com.campuskul.user.operations.model.College;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StaffResponseDTO {
    private Long id;
    private Long userId;
    private String name;
    private College college;  // instead of collegeId, return readable name
    private String mobile;
    private String email;
    private String address;
    private String subject;
    private String position;
    private String status;
    private Long createdby;
    private LocalDateTime createdate;
    private Long updatedby;
    private LocalDateTime updatedate;
}
