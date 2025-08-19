package com.campuskul.user.operations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "college_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private String collegeLogo;

    private String collegeBanner;

    private String accrCertificate;

    private String regCertificate;

    private String instituteProfile;

    private String contactInfo;

    private String authLetter;

    private String privacy;

    private String terms;

    private String listofcourse;

    private int status;

    private String createdby;

    private LocalDateTime createdate;

    private String updatedby;

    private LocalDateTime updatedate;
}
