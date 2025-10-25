package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import com.daonq1408.workshopbesql.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;


    @GetMapping("")
    public ResponseEntity<ApiResponse<List<LevelResponse>>> getLevels() {
        List<LevelResponse> resp = levelService.getLevels();
        return ResponseEntity.ok(ApiResponse.success(resp, "All levels retrieved successfully"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LevelResponse>> getLevelById(@PathVariable long id) {
        LevelResponse resp = levelService.getLevelById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level retrieved successfully"));
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse<LevelResponse>> addLevel(@RequestBody LevelRequest levelRequest) {
        LevelResponse created = levelService.saveLevel(levelRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "Level created successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LevelResponse>> updateLevel(@PathVariable long id,
                                                     @RequestBody LevelRequest levelRequest) {
        LevelResponse resp = levelService.updateLevel(id, levelRequest);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<LevelResponse>> deleteLevel(@PathVariable long id) {
        LevelResponse resp = levelService.deleteLevel(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level deleted successfully"));
    }
}
