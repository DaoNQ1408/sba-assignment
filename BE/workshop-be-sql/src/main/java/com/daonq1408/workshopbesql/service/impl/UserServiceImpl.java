package com.daonq1408.workshopbesql.service.impl;

import com.daonq1408.workshopbesql.dto.request.UserRequest;
import com.daonq1408.workshopbesql.dto.response.UserResponse;
import com.daonq1408.workshopbesql.entity.User;
import com.daonq1408.workshopbesql.mapper.UserMapper;
import com.daonq1408.workshopbesql.repository.UserRepository;
import com.daonq1408.workshopbesql.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User findById(long teacherId) {
        return userRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User not found with id " +
                                teacherId)
                );
    }


    @Override
    public UserResponse findResponseById(long teacherId) {
        return userMapper.toResponse(findById(teacherId));
    }


    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public UserResponse saveTeacher(UserRequest userRequest) {

        User user = userMapper.toEntity(userRequest);

        return userMapper.toResponse(userRepository.save(user));
    }


    @Override
    @Transactional
    public UserResponse updateTeacher(long teacherId, UserRequest userRequest) {

        User user = findById(teacherId);

        userMapper.updateEntityFromRequest(user, userRequest);

        User updatedUser = userRepository.save(user);

        return userMapper.toResponse(updatedUser);
    }


    @Override
    @Transactional
    public UserResponse deleteTeacher(long teacherId) {

        User user = findById(teacherId);

        userRepository.delete(user);

        return userMapper.toResponse(user);
    }
}
