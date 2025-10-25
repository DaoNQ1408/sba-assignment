package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
import com.daonq1408.workshopbesql.dto.response.ApiResponse;
import com.daonq1408.workshopbesql.dto.response.OptionResponse;
import com.daonq1408.workshopbesql.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<OptionResponse>>> getAllOptions() {
        List<OptionResponse> resp = optionService.getAllOptions();
        return ResponseEntity.ok(ApiResponse.success(resp, "All options retrieved successfully"));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OptionResponse>> getOptionById(@PathVariable long id) {
        OptionResponse resp = optionService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Option retrieved successfully"));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<OptionResponse>> createOption(@RequestBody OptionRequest request) {
        OptionResponse createdOption = optionService.saveOption(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(createdOption, "Option created successfully"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OptionResponse>> updateOption(@PathVariable long id,
                                                       @RequestBody OptionRequest request) {
        OptionResponse resp = optionService.updateOption(id, request);
        return ResponseEntity.ok(ApiResponse.success(resp, "Option updated successfully"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<OptionResponse>> deleteOption(@PathVariable long id) {
        OptionResponse resp = optionService.deleteOption(id);
        return ResponseEntity.ok(ApiResponse.success(resp, "Option deleted successfully"));
    }
}
