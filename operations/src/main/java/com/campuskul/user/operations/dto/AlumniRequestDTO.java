package com.campuskul.user.operations.dto;

import lombok.Data;

@Data
public class AlumniRequestDTO {
    private Long userId;
    private String alumniName;
    private Long collegeId;
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
    private Long updatedby;
}
