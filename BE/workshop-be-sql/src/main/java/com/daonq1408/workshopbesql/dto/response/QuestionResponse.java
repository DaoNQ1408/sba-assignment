package com.daonq1408.workshopbesql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
    private long id;
    private String question;
    private LessonResponse lesson;
    private LevelResponse level;
    private QuestionTypeResponse questionType;
    private List<OptionResponse> options;
}
