package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.UserRequest;
import com.daonq1408.workshopbesql.dto.response.UserResponse;
import com.daonq1408.workshopbesql.entity.User;

import java.util.List;

public interface UserService {
    User findById(long teacherId);
    UserResponse findResponseById(long teacherId);
    List<UserResponse> getAll();
    UserResponse saveTeacher(UserRequest userRequest);
    UserResponse updateTeacher(long teacherId, UserRequest userRequest);
    UserResponse deleteTeacher(long teacherId);
}
