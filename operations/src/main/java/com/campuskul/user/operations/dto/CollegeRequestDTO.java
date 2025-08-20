package com.campuskul.user.operations.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CollegeRequestDTO {
    private Long branchId;
    private String collegeName;
    private String contactPersonName;
    private String personPost;
    private String contactPersonNumber;
    private String contactPersonEmail;
    private int establishedYear;
    private String addr1;
    private String addr2;
    private String addr3;
    private int zipcode;

    // File fields
    private MultipartFile collegeLogo;
    private MultipartFile collegeBanner;
    private MultipartFile accrCertificate;
    private MultipartFile regCertificate;
    private MultipartFile instituteProfile;
    private MultipartFile authLetter;
    private MultipartFile privacy;
    private MultipartFile terms;

    private String listofcourse;
    private int status;
    private Long updatedby;
    private Long createdby;
}
