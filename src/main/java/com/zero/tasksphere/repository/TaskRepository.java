package com.zero.tasksphere.repository;

import com.zero.tasksphere.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Task
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Busca todas las tareas de un usuario específico
     * @param userId el ID del usuario
     * @return lista de tareas del usuario
     */
    List<Task> findByUserId(Long userId);

    /**
     * Busca tareas por nombre (búsqueda parcial, case insensitive)
     * @param nombre el nombre o parte del nombre de la tarea
     * @return lista de tareas que coinciden
     */
    List<Task> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Cuenta las tareas de un usuario específico
     * @param userId el ID del usuario
     * @return número de tareas del usuario
     */
    long countByUserId(Long userId);
}

