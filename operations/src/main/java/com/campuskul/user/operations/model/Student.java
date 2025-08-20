package com.campuskul.user.operations.model;

import com.campuskul.user.operations.model.College;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    private String studentName;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College collegeId;

    private String studentMobile;
    private String studentEmail;
    private String studentAddr;
    private String studentDept;
    private String studentYear;
    private String passingYear;
    private String university;
    private String degree;
//    private Long countryId;
//    private Long stateId;
//    private Long cityId;
    private String pincode;
    private String about;
    private String motherName;
    private String profilepic;
    private String status;
    private String createdby;

    @Column(name = "createdate", nullable = false, updatable = false)
    private LocalDateTime createdate;
    private String updatedby;
    private LocalDateTime updatedate;
}
