-- ==============================
-- USUARIOS
-- ==============================
INSERT INTO usuarios (id, nombre, correo, tipo, estado) VALUES
(1, 'Andrés Coneo', 'andres.coneo@correo.itm.edu.co', 'estudiante', 'activo'),
(2, 'María Pérez', 'maria.perez@correo.itm.edu.co', 'docente', 'activo'),
(3, 'Carlos López', 'carlos.lopez@correo.itm.edu.co', 'empleado', 'activo'),
(4, 'Laura Sánchez', 'laura.sanchez@correo.itm.edu.co', 'estudiante', 'activo'),
(5, 'Pedro Ramírez', 'pedro.ramirez@correo.itm.edu.co', 'docente', 'activo'),
(6, 'Ana Torres', 'ana.torres@correo.itm.edu.co', 'empleado', 'activo'),
(7, 'Jorge Díaz', 'jorge.diaz@correo.itm.edu.co', 'estudiante', 'activo'),
(8, 'Paula Gómez', 'paula.gomez@correo.itm.edu.co', 'docente', 'activo'),
(9, 'Luis Martínez', 'luis.martinez@correo.itm.edu.co', 'estudiante', 'activo'),
(10, 'Claudia Rodríguez', 'claudia.rodriguez@correo.itm.edu.co', 'empleado', 'activo'),
(11, 'David Hernández', 'david.hernandez@correo.itm.edu.co', 'docente', 'activo'),
(12, 'Camila Ríos', 'camila.rios@correo.itm.edu.co', 'estudiante', 'activo'),
(13, 'Felipe Castro', 'felipe.castro@correo.itm.edu.co', 'empleado', 'activo'),
(14, 'Natalia Morales', 'natalia.morales@correo.itm.edu.co', 'estudiante', 'activo'),
(15, 'Ricardo Vega', 'ricardo.vega@correo.itm.edu.co', 'docente', 'activo'),
(16, 'Sara Ortiz', 'sara.ortiz@correo.itm.edu.co', 'empleado', 'activo'),
(17, 'Mateo Jiménez', 'mateo.jimenez@correo.itm.edu.co', 'estudiante', 'activo'),
(18, 'Valentina Herrera', 'valentina.herrera@correo.itm.edu.co', 'docente', 'activo'),
(19, 'Esteban Cárdenas', 'esteban.cardenas@correo.itm.edu.co', 'estudiante', 'activo'),
(20, 'Diana Patiño', 'diana.patino@correo.itm.edu.co', 'empleado', 'activo');

-- ==============================
-- LIBROS
-- ==============================
INSERT INTO libros (id, titulo, autor, anio_publicacion, categoria, estado) VALUES
(21, 'Cien años de soledad', 'Gabriel García Márquez', 1967, 'Novela', 'disponible'),
(22, 'El amor en los tiempos del cólera', 'Gabriel García Márquez', 1985, 'Novela', 'disponible'),
(23, 'La hojarasca', 'Gabriel García Márquez', 1955, 'Novela', 'disponible'),
(24, 'Rayuela', 'Julio Cortázar', 1963, 'Novela', 'disponible'),
(25, 'El Aleph', 'Jorge Luis Borges', 1949, 'Cuento', 'disponible'),
(26, 'Pedro Páramo', 'Juan Rulfo', 1955, 'Novela', 'disponible'),
(27, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 1605, 'Novela', 'disponible'),
(28, 'La ciudad y los perros', 'Mario Vargas Llosa', 1963, 'Novela', 'disponible'),
(29, 'Conversación en La Catedral', 'Mario Vargas Llosa', 1969, 'Novela', 'disponible'),
(30, 'El Principito', 'Antoine de Saint-Exupéry', 1943, 'Fábula', 'disponible'),
(31, 'Crimen y castigo', 'Fiódor Dostoyevski', 1866, 'Novela', 'disponible'),
(32, 'Los hermanos Karamazov', 'Fiódor Dostoyevski', 1880, 'Novela', 'disponible'),
(33, 'La metamorfosis', 'Franz Kafka', 1915, 'Novela corta', 'disponible'),
(34, 'Orgullo y prejuicio', 'Jane Austen', 1813, 'Novela', 'disponible'),
(35, '1984', 'George Orwell', 1949, 'Distopía', 'disponible'),
(36, 'Rebelión en la granja', 'George Orwell', 1945, 'Fábula política', 'disponible'),
(37, 'Fahrenheit 451', 'Ray Bradbury', 1953, 'Distopía', 'disponible'),
(38, 'El señor de los anillos', 'J.R.R. Tolkien', 1954, 'Fantasía', 'disponible'),
(39, 'El hobbit', 'J.R.R. Tolkien', 1937, 'Fantasía', 'disponible'),
(40, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 1997, 'Fantasía', 'disponible');

-- ==============================
-- PRESTAMOS
-- ==============================
INSERT INTO prestamos (usuario_id, libro_id, fecha_prestamo, fecha_devolucion, estado) VALUES
(1, 21, '2025-09-01', '2025-09-15', 'devuelto'),
(2, 22, '2025-09-10', '2025-09-25', 'prestado'),
(3, 23, '2025-09-05', '2025-09-20', 'atrasado'),
(4, 24, '2025-09-12', '2025-09-27', 'prestado'),
(5, 25, '2025-09-15', '2025-09-22', 'atrasado'),
(6, 26, '2025-09-18', '2025-10-03', 'prestado'),
(7, 27, '2025-09-02', '2025-09-17', 'devuelto'),
(8, 28, '2025-09-08', '2025-09-23', 'prestado'),
(9, 29, '2025-09-01', '2025-09-10', 'atrasado'),
(10, 30, '2025-09-20', '2025-10-05', 'prestado');
