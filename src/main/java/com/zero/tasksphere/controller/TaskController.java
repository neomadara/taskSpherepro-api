package com.zero.tasksphere.controller;


import com.zero.tasksphere.dto.TaskCreationDto;
import com.zero.tasksphere.dto.TaskResponseDto;
import com.zero.tasksphere.service.JwtService;
import com.zero.tasksphere.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final JwtService jwtService;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskCreationDto taskCreationDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Jwt jwt = (Jwt) authentication.getPrincipal();
        Long userId = jwt.getClaim("userId");

        TaskResponseDto taskResponse = taskService.createTask(taskCreationDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

}
