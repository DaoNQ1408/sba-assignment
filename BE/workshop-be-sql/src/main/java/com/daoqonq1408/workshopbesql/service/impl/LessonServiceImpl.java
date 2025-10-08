package com.daoqonq1408.workshopbesql.service.impl;

import com.daoqonq1408.workshopbesql.dto.request.LessonRequest;
import com.daoqonq1408.workshopbesql.dto.response.GradeResponse;
import com.daoqonq1408.workshopbesql.dto.response.LessonResponse;
import com.daoqonq1408.workshopbesql.dto.response.SubjectResponse;
import com.daoqonq1408.workshopbesql.entity.Lesson;
import com.daoqonq1408.workshopbesql.entity.Subject;
import com.daoqonq1408.workshopbesql.exception.DuplicateObjectException;
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

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
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

//    @Override
//    @Transactional
//    public LessonResponse addLesson(LessonRequest lessonRequest) {
//        lessonRepository.findByTitle(lessonRequest.getTitle()).ifPresent(subject -> {
//            throw new DuplicateObjectException("Subject already exists with name: " + request.getName());
//        });
//
//        Subject subject = subjectRepository.save(new Subject(request.getName()));
//        return SubjectResponse.builder()
//                .id(subject.getId())
//                .name(subject.getName())
//                .build();
//    }

    @Override
    @Transactional
    public LessonResponse updateLesson(long id, LessonRequest lessonRequest) {
        return null;
    }

    @Override
    @Transactional
    public LessonResponse deleteLesson(long lessonId) {
        return null;
    }
}
