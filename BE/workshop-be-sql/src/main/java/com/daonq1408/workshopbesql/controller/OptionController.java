package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.OptionRequest;
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
    public ResponseEntity<List<OptionResponse>> getAllOptions() {
        return ResponseEntity.ok(optionService.getAllOptions());
    }


    @GetMapping("/{id}")
    public ResponseEntity<OptionResponse> getOptionById(@PathVariable long id) {
        return ResponseEntity.ok(optionService.getById(id));
    }


    @PostMapping
    public ResponseEntity<OptionResponse> createOption(@RequestBody OptionRequest request) {
        OptionResponse createdOption = optionService.save(request);
        return new ResponseEntity<>(createdOption, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<OptionResponse> updateOption(@PathVariable long id,
                                                       @RequestBody OptionRequest request) {
        return ResponseEntity.ok(optionService.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<OptionResponse> deleteOption(@PathVariable long id) {
        return ResponseEntity.ok(optionService.delete(id));
    }
}
