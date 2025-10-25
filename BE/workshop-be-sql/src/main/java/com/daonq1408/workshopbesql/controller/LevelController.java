package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.LevelResponse;
import com.daonq1408.workshopbesql.service.LevelService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class LevelController {

    private final LevelService levelService;


    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<List<LevelResponse>>> getLevels() {
        List<LevelResponse> resp = levelService.getLevels();
        return ResponseEntity.ok(ApiResponse.success(resp, "All levels retrieved successfully"));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<LevelResponse>> getLevelById(@PathVariable long id) {
        LevelResponse resp = levelService.getLevelById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level retrieved successfully"));
    }


    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LevelResponse>> addLevel(@RequestBody LevelRequest levelRequest) {
        LevelResponse created = levelService.saveLevel(levelRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "Level created successfully"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LevelResponse>> updateLevel(@PathVariable long id,
                                                     @RequestBody LevelRequest levelRequest) {
        LevelResponse resp = levelService.updateLevel(id, levelRequest);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level updated successfully"));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<LevelResponse>> deleteLevel(@PathVariable long id) {
        LevelResponse resp = levelService.deleteLevel(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Level deleted successfully"));
    }
}
