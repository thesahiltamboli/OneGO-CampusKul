package com.campuskul.user.operations.controller;

import com.campuskul.user.operations.dto.StaffRequestDTO;
import com.campuskul.user.operations.dto.StaffResponseDTO;
import com.campuskul.user.operations.dto.StudentResponseDTO;
import com.campuskul.user.operations.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/getAllStaff")
    public ResponseEntity<Map<String,Object>> getAllStaff() {
        Map<String,Object> response = new HashMap<>();
        List<StaffResponseDTO> staff = staffService.getAllStaff();
        if(!staff.isEmpty()){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", staff);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String,Object>> getById(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        StaffResponseDTO staff = staffService.getByd(id);
        if(staff !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", staff);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @PostMapping("/addStaff")
    public ResponseEntity<Map<String,Object>> addStaff(@RequestBody StaffRequestDTO staffRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        StaffResponseDTO staff = staffService.addStaff(staffRequestDTO);
        if(staff != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", staff);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/editStaff/{id}")
    public ResponseEntity<Map<String,Object>> editStaff(@PathVariable Long id, @RequestBody StaffRequestDTO staffRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        StaffResponseDTO staff = staffService.editStaff(id, staffRequestDTO);
        if(staff != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", staff);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in updating staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/deleteStaff/{id}")
    public ResponseEntity<Map<String,Object>> deleteStaff(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        StaffResponseDTO staff = staffService.deleteStaff(id);
        if(staff != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", staff);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in deleting staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
