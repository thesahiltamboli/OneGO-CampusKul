package com.campuskul.user.operations.controller;
import com.campuskul.user.operations.dto.CollegeRequestDTO;
import com.campuskul.user.operations.dto.CollegeResponseDTO;
import com.campuskul.user.operations.dto.StaffResponseDTO;
import com.campuskul.user.operations.dto.CollegeResponseDTO;
import com.campuskul.user.operations.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/colleges")
@RequiredArgsConstructor
public class CollegeController {


    private final CollegeService collegeService;

    @GetMapping("/getAllColleges")
    public ResponseEntity<Map<String,Object>> getAllColleges() {
        Map<String,Object> response = new HashMap<>();
        List<CollegeResponseDTO> college = collegeService.getAllColleges();
        if(!college.isEmpty()){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", college);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching colleges");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/getCollegeById/{id}")
    public ResponseEntity<Map<String,Object>> getCollegeById(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        CollegeResponseDTO college = collegeService.getCollegeById(id);
        if(college !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", college);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching colleges");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @PostMapping("/addCollege")
    public ResponseEntity<Map<String,Object>> addCollege(@ModelAttribute CollegeRequestDTO dto) throws IOException {
        Map<String,Object> response = new HashMap<>();
        CollegeResponseDTO college = collegeService.addCollege(dto);
        if(college !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", college);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in adding colleges");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/editCollege/{id}")
    public ResponseEntity<Map<String,Object>> editCollege(@PathVariable Long id,@ModelAttribute CollegeRequestDTO dto) throws IOException {
        Map<String,Object> response = new HashMap<>();
        CollegeResponseDTO college = collegeService.editCollege(id, dto);
        if(college !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", college);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in updating colleges");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/deleteCollege/{id}")
    public ResponseEntity<Map<String,Object>> deleteCollege(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        CollegeResponseDTO college = collegeService.deleteCollege(id);
        if(college !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", college);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in deleted colleges");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
