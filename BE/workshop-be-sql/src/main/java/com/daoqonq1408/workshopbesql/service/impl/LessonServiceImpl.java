package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.LessonRequest;
import com.daoqonq1408.workshopbesql.dto.response.LessonResponse;
import com.daoqonq1408.workshopbesql.entity.Grade;
import com.daoqonq1408.workshopbesql.entity.Lesson;
import com.daoqonq1408.workshopbesql.exception.DuplicateObjectException;
import com.daoqonq1408.workshopbesql.repository.GradeRepository;
import com.daoqonq1408.workshopbesql.repository.LessonRepository;
import com.daoqonq1408.workshopbesql.service.LessonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final GradeRepository gradeRepository;

    public LessonServiceImpl(LessonRepository lessonRepository, GradeRepository gradeRepository) {
        this.lessonRepository = lessonRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public LessonResponse getLesson(long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Can not find less with id: " + lessonId));

        return LessonResponse.builder()
                .id(lesson.getId())
                .gradeId(lesson.getGrade().getId())
                .title(lesson.getTitle())
                .build();
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lesson -> LessonResponse.builder()
                        .id(lesson.getId())
                        .gradeId(lesson.getGrade().getId())
                        .title(lesson.getTitle())
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public LessonResponse addLesson(LessonRequest lessonRequest) {
        lessonRepository.findByTitle(lessonRequest.getTitle()).ifPresent(subject -> {
            throw new DuplicateObjectException("Subject already exists with title: " + lessonRequest.getTitle());
        });

        Lesson lesson = lessonRepository.save(new Lesson(lessonRequest.getTitle(),
                gradeRepository.findById(lessonRequest.getGradeId())
                        .orElseThrow(() -> new EntityNotFoundException("Can not find grade with id: " + lessonRequest.getGradeId()))));

        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .gradeId(lesson.getGrade().getId())
                .build();
    }

    @Override
    @Transactional
    public LessonResponse updateLesson(long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with id: " + id));

        Grade grade = gradeRepository.findById(lessonRequest.getGradeId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Grade not found with id: " + lessonRequest.getGradeId()));

        lesson.setGrade(grade);
        lesson.setTitle(lessonRequest.getTitle());

        Lesson updatedLesson = lessonRepository.save(lesson);

        return LessonResponse.builder()
                .id(updatedLesson.getId())
                .title(updatedLesson.getTitle())
                .gradeId(updatedLesson.getGrade().getId())
                .build();
    }

    @Override
    @Transactional
    public LessonResponse deleteLesson(long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with id: " + lessonId));

        lessonRepository.delete(lesson);

        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .gradeId(lesson.getGrade().getId())
                .build();
    }
}
