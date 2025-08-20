package com.campuskul.user.operations.dto;

import com.campuskul.user.operations.model.College;
import com.campuskul.user.operations.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlumniResponseDTO {
    private Long id;
    private User userId;
    private String alumniName;
    private College collegeId;
    private String alumniMobile;
    private String alumniEmail;
    private String alumniAddr;
    private Integer alumniYear;
    private String university;
    private String pincode;
    private String about;
    private String companyName;
    private String profilepic;
    private Boolean isMentor;
    private String status;
    private Long createdby;
    private LocalDateTime createddate;
    private Long updatedby;
    private LocalDateTime updatedate;
}

