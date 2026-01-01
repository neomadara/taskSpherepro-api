-- Crear tabla de tareas
CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_tasks_user FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Índice para búsquedas por usuario
CREATE INDEX idx_tasks_user_id ON tasks(user_id);

-- Índice para búsquedas por nombre
CREATE INDEX idx_tasks_nombre ON tasks(nombre);

-- Comentarios para documentación
COMMENT ON TABLE tasks IS 'Tabla de tareas del sistema';
COMMENT ON COLUMN tasks.id IS 'Identificador único de la tarea';
COMMENT ON COLUMN tasks.nombre IS 'Nombre de la tarea';
COMMENT ON COLUMN tasks.descripcion IS 'Descripción detallada de la tarea';
COMMENT ON COLUMN tasks.user_id IS 'ID del usuario propietario de la tarea';
COMMENT ON COLUMN tasks.created_at IS 'Fecha de creación del registro';
COMMENT ON COLUMN tasks.updated_at IS 'Fecha de última actualización del registro';

