package com.campuskul.user.operations.dto;

import lombok.Data;

@Data
public class StaffRequestDTO {
    private Long userId;
    private String name;
    private Long collegeId;
    private String mobile;
    private String email;
    private String address;
    private String subject;
    private String position;
    private String status;
    private Long createdby;
    private Long updatedby;
}
