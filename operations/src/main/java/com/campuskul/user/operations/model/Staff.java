package com.campuskul.user.operations.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College collegeId;

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

