package com.campuskul.user.operations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {
    private Long id;
    private Long userId;
    private String studentName;
    private Long collegeId;
    private String studentMobile;
    private String studentEmail;
    private String studentAddr;
    private String studentDept;
    private String studentYear;
    private String passingYear;
    private String university;
    private String degree;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private String pincode;
    private String about;
    private String motherName;
    private String profilepic;
    private String status;
    private String createdby;
    private LocalDateTime createdate;
    private String updatedby;
    private LocalDateTime updatedate;
}
