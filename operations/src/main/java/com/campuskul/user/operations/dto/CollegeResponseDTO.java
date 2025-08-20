package com.campuskul.user.operations.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CollegeResponseDTO {
    private Long id;
    private String collegeName;
    private String contactPersonName;
    private String contactPersonEmail;
    private Long branchId;
    private String accrCertificate;
    private String regCertificate;
    private String authLetter;
    private String privacy;
    private String personPost;
    private String contactPersonNumber;
    private String listofcourse;
    private String terms;
    private int establishedYear;
    private String addr1;
    private String addr2;
    private String addr3;
    private int zipcode;
    private String collegeLogo;
    private String collegeBanner;
    private String instituteProfile;
    private String contactInfo;
    private int status;
    private Long createdby;
    private LocalDateTime createdate;
    private Long updatedby;
    private LocalDateTime updatedate;

}
