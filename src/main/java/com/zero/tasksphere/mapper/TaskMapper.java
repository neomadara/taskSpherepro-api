package com.zero.tasksphere.mapper;

import com.zero.tasksphere.dto.TaskResponseDto;
import com.zero.tasksphere.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toDto(Task task);
}
