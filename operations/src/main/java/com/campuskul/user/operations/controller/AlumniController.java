package com.campuskul.user.operations.controller;




import com.campuskul.user.operations.dto.AlumniRequestDTO;
import com.campuskul.user.operations.dto.AlumniResponseDTO;
import com.campuskul.user.operations.dto.StaffResponseDTO;
import com.campuskul.user.operations.model.Alumni;
import com.campuskul.user.operations.service.AlumniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alumni")
public class AlumniController {

    private final AlumniService alumniService;

    public AlumniController(AlumniService alumniService) {
        this.alumniService = alumniService;
    }


    @GetMapping("/getAllAlumni")
    public ResponseEntity<Map<String,Object>> getAllAlumni() {
        Map<String,Object> response = new HashMap<>();
        List<AlumniResponseDTO> alumines = alumniService.getAllAlumines();
        if(!alumines.isEmpty()){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", alumines);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching staff");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/getAlumniById/{id}")
    public ResponseEntity<Map<String,Object>> getAlumniById(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        AlumniResponseDTO alumi = alumniService.getAlumniById(id);
        if(alumi != null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", alumi);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in fetching alumi");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/addAlumni")
    public ResponseEntity<Map<String,Object>> addAlumni(@RequestBody AlumniRequestDTO alumniRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        AlumniResponseDTO alumines = alumniService.addAlumni(alumniRequestDTO);
        if(alumines !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", alumines);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in adding Alumni");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/editAlumni/{id}")
    public ResponseEntity<Map<String,Object>> addAlumni(@PathVariable Long id, @RequestBody AlumniRequestDTO alumniRequestDTO) {
        Map<String,Object> response = new HashMap<>();
        AlumniResponseDTO alumni = alumniService.editAlumni(id,alumniRequestDTO);
        if(alumni !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", alumni);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in editing Alumni");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/deleteAlumni/{id}")
    public ResponseEntity<Map<String,Object>> deleteAlumni(@PathVariable Long id) {
        Map<String,Object> response = new HashMap<>();
        AlumniResponseDTO alumni = alumniService.deleteAlumni(id);
        if(alumni !=null){
            response.put("status", true);
            response.put("message", "Success");
            response.put("data", alumni);
            return ResponseEntity.ok().body(response);
        }
        else{
            response.put("status", false);
            response.put("message", "Error in deleting Alumni");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
