package com.zero.tasksphere.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskCreationDto {
    @NotBlank(message = "El nombre de la tarea no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre de la tarea debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion de la tarea no puede estar vacío")
    @Size(min = 3, message = "La descripcion de la tarea debe tener al menos 3 caracteres")
    private String descripcion;
}
