package com.zero.tasksphere.service;

import com.zero.tasksphere.dto.TaskCreationDto;
import com.zero.tasksphere.dto.TaskResponseDto;
import com.zero.tasksphere.entity.Task;
import com.zero.tasksphere.entity.User;
import com.zero.tasksphere.mapper.TaskMapper;
import com.zero.tasksphere.repository.TaskRepository;
import com.zero.tasksphere.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Transactional
    public TaskResponseDto createTask(TaskCreationDto taskCreationDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Task task = Task.builder()
                .nombre(taskCreationDto.getNombre())
                .descripcion(taskCreationDto.getDescripcion())
                .user(user)
                .build();

        Task savedTask = taskRepository.save(task);

        return taskMapper.toDto(savedTask);
    }
}
