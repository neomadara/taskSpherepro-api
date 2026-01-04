package com.zero.tasksphere.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long userId;
}
