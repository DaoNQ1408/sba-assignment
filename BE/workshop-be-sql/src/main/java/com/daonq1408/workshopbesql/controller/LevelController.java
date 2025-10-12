package com.daonq1408.workshopbesql.controller;

import com.daonq1408.workshopbesql.dto.request.LevelRequest;
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
    public ResponseEntity<List<LevelResponse>> getLevels() {
        return ResponseEntity.ok(levelService.getLevels());
    }



    @GetMapping("/{id}")
    public ResponseEntity<LevelResponse> getLevelById(@PathVariable long id) {
        return ResponseEntity.ok(levelService.getLevelById(id));
    }



    @PostMapping("")
    public ResponseEntity<LevelResponse> addLevel(@RequestBody LevelRequest levelRequest) {
        return new ResponseEntity<>(levelService.addLevel(levelRequest),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LevelResponse> updateLevel(@PathVariable long id,
                                                     @RequestBody LevelRequest levelRequest) {
        return ResponseEntity.ok(levelService.updateLevel(id, levelRequest));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<LevelResponse> deleteLevel(@PathVariable long id) {
        return ResponseEntity.ok(levelService.deleteLevel(id));
    }
}
