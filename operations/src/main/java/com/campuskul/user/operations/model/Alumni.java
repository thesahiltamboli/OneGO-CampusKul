package com.campuskul.user.operations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alumni_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    
    private String alumniName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
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
    @Column(name = "createdate", nullable = false, updatable = false)
    private LocalDateTime createddate;
    private Long updatedby;
    private LocalDateTime updatedate;
}
