package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.LessonRequest;
import com.daonq1408.workshopbesql.dto.response.LessonResponse;
import com.daonq1408.workshopbesql.entity.Grade;
import com.daonq1408.workshopbesql.entity.Lesson;
import com.daonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daonq1408.workshopbesql.mapper.LessonMapper;
import com.daonq1408.workshopbesql.repository.LessonRepository;
import com.daonq1408.workshopbesql.service.GradeService;
import com.daonq1408.workshopbesql.service.LessonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final GradeService gradeService;
    private final LessonMapper lessonMapper;


    @Override
    public LessonResponse getLesson(long lessonId) {

        Lesson lesson = findById(lessonId);

        return lessonMapper.toResponse(lesson);
    }


    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public LessonResponse addLesson(LessonRequest lessonRequest) {

        endIfLessonTitleExist(lessonRequest.getTitle());

        Lesson lesson = lessonRepository.save(lessonMapper.toEntity(lessonRequest));

        return lessonMapper.toResponse(lesson);
    }


    @Override
    @Transactional
    public LessonResponse updateLesson(long id, LessonRequest lessonRequest) {

        Lesson lesson = findById(id);

        Grade grade = gradeService.findById(lessonRequest.getGradeId());

        lesson.setGrade(grade);
        lesson.setTitle(lessonRequest.getTitle());

        Lesson updatedLesson = lessonRepository.save(lesson);

        return lessonMapper.toResponse(updatedLesson);
    }


    @Override
    @Transactional
    public LessonResponse deleteLesson(long lessonId) {

        Lesson lesson = findById(lessonId);

        lessonRepository.delete(lesson);

        return lessonMapper.toResponse(lesson);
    }


    @Override
    public Lesson findById(long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Lesson not found with id: " +
                                id)
                );
    }


    public void endIfLessonTitleExist(String title) {
        lessonRepository.findByTitle(title)
                .ifPresent(lesson -> {
                    throw new DuplicateObjectException(
                            "Lesson already exists with title: " +
                                    title);
                });
    }
}
