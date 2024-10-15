-- Crear base de datos
CREATE DATABASE IF NOT EXISTS asegurados_db;
USE asegurados_db;

-- Crear tabla de ASEGURADOS
CREATE TABLE IF NOT EXISTS asegurados (
                                          id SERIAL PRIMARY KEY,
                                          tipo_identificacion INT NOT NULL,  -- 1: CC, 2: CE
                                          numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
                                          apellidos VARCHAR(50) NOT NULL,
                                          nombres VARCHAR(50) NOT NULL,
                                          sexo INT NOT NULL,                  -- 1: Masculino, 2: Femenino
                                          fecha_nacimiento DATE NOT NULL
);

-- Insertar datos en ASEGURADOS
INSERT IGNORE INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento)
VALUES
    (1, '79000001', 'APELLIDO1', 'NOMBRE1', 1, '1999-01-10'),
    (1, '79000002', 'APELLIDO2', 'NOMBRE2', 1, '1999-01-10'),
    (1, '79000003', 'APELLIDO3', 'NOMBRE3', 1, '1999-01-10'),
    (2, '51000001', 'APELLIDO4', 'NOMBRE4', 2, '1999-01-10'),
    (2, '51000002', 'APELLIDO5', 'NOMBRE5', 2, '1999-01-10'),
    (2, '51000003', 'APELLIDO6', 'NOMBRE6', 2, '1999-01-10');

-- Crear tabla de AMPAROS
CREATE TABLE IF NOT EXISTS amparos (
                                       codigo INT PRIMARY KEY AUTO_INCREMENT,
                                       nombre VARCHAR(100) NOT NULL
);

-- Insertar datos en AMPAROS
INSERT IGNORE INTO amparos (nombre)
VALUES
    ('Muerte accidental'),
    ('Desmembración'),
    ('Auxilio funerario'),
    ('Renta vitalicia');

-- Crear tabla de PRIMAS
CREATE TABLE IF NOT EXISTS primas (
                                      codigo INT PRIMARY KEY AUTO_INCREMENT,
                                      edad_minima INT NOT NULL,
                                      edad_maxima INT NOT NULL,
                                      porcentaje_prima DECIMAL(10,5) NOT NULL,
                                      codigo_amparo INT NOT NULL,
                                      FOREIGN KEY (codigo_amparo) REFERENCES amparos(codigo) ON DELETE CASCADE
);

-- Insertar datos en PRIMAS
INSERT IGNORE INTO primas (edad_minima, edad_maxima, porcentaje_prima, codigo_amparo)
VALUES
    (18, 45, 0.02304, 1),
    (46, 75, 0.02012, 1),
    (18, 50, 0.18090, 2),
    (51, 70, 0.16043, 2),
    (18, 60, 0.14123, 3),
    (61, 70, 0.15450, 3),
    (18, 50, 0.12123, 4),
    (51, 70, 0.13450, 4);

