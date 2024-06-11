INSERT INTO "grados" ("nombre","codigo")
VALUES
('Sexto','A'),
('Séptimo','A'),
('Octavo','A'),
('Noveno','A'),
('Décimo','A'),
('Undécimo','A');

INSERT INTO "materias" ("nombre")
VALUES
('Matemáticas'),
('Lengua y Literatura'),
('Ciencias Naturales'),
('Ciencias Sociales'),
('Educación Física'),
('Arte');

INSERT INTO "materias_grados" ("id_materia","id_grado")
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(3,1),
(3,2),
(3,3),
(3,4),
(3,5),
(3,6),
(4,1),
(4,2),
(4,3),
(4,4),
(4,5),
(4,6),
(5,1),
(5,2),
(5,3),
(5,4),
(5,5),
(5,6),
(6,1),
(6,2),
(6,3),
(6,4),
(6,5),
(6,6);

INSERT INTO "temas" ("nombre","descripcion","id_materia", "id_grado")
VALUES
('Aritmética','Operaciones básicas con números',1,1),
('Geometría','Estudio de figuras y cuerpos geométricos',1,1),
('Álgebra','Resolución de ecuaciones y expresiones algebraicas',1,2),
('Literatura Clásica','Estudio de obras literarias clásicas',2,3),
('Gramática','Reglas y estructura del idioma',2,4),
('Redacción','Técnicas de escritura y composición',2,6),
('Biología','Estudio de los seres vivos',3,1),
('Física','Estudio de las leyes del universo',3,2),
('Química','Estudio de la materia y sus transformaciones',3,5),
('Historia','Estudio de hechos y procesos históricos',4,5),
('Geografía','Estudio del espacio geográfico',4,1),
('Civismo','Estudio de la ciudadanía y sus deberes',4,2),
('Deportes','Práctica de actividades físicas y deportes',5,6),
('Educación Física Teórica','Estudio de teorías sobre la actividad física',5,3),
('Arte Visual','Estudio y práctica de las artes visuales',6,6),
('Música','Estudio y práctica de la música',6,2);

INSERT INTO "docentes" ("nombres","apellidos","correo","clave","estado","id_materia")
VALUES
('Juan','Pérez','juan.perez@colegio.edu.co','clave1','Activo',1),
('María','López','maria.lopez@colegio.edu.co','clave2','Activo',2),
('Carlos','García','carlos.garcia@colegio.edu.co','clave3','Activo',3),
('Ana','Martínez','ana.martinez@colegio.edu.co','clave4','Activo',4),
('Luis','Hernández','luis.hernandez@colegio.edu.co','clave5','Activo',5),
('Laura','González','laura.gonzalez@colegio.edu.co','clave6','Activo',6),
('Pedro','Rodríguez','pedro.rodriguez@colegio.edu.co','clave7','Activo',1),
('Sofía','Fernández','sofia.fernandez@colegio.edu.co','clave8','Activo',2),
('José','Sánchez','jose.sanchez@colegio.edu.co','clave9','Activo',3),
('Claudia','Ramírez','claudia.ramirez@colegio.edu.co','clave10','Activo',4),
('Miguel','Torres','miguel.torres@colegio.edu.co','clave11','Activo',5),
('Elena','Flores','elena.flores@colegio.edu.co','clave12','Activo',6);

INSERT INTO "estudiantes" ("nombres", "apellidos", "correo", "clave", "estado", "id_grado")
VALUES
('Alejandro', 'Gómez', 'estudiante11@colegio.edu.co', 'clave123', 'Activo', 1),
('Lucía', 'Martínez', 'estudiante12@colegio.edu.co', 'clave123', 'Activo', 1),
('Mateo', 'Hernández', 'estudiante13@colegio.edu.co', 'clave123', 'Activo', 1),
('Sofía', 'Pérez', 'estudiante14@colegio.edu.co', 'clave123', 'Activo', 1),
('Diego', 'Rodríguez', 'estudiante15@colegio.edu.co', 'clave123', 'Activo', 1),
('Camila', 'López', 'estudiante16@colegio.edu.co', 'clave123', 'Activo', 1),
('Valentina', 'González', 'estudiante17@colegio.edu.co', 'clave123', 'Activo', 1),
('Daniel', 'Fernández', 'estudiante21@colegio.edu.co', 'clave123', 'Activo', 2),
('Santiago', 'García', 'estudiante22@colegio.edu.co', 'clave123', 'Activo', 2),
('María', 'Méndez', 'estudiante23@colegio.edu.co', 'clave123', 'Activo', 2),
('Antonio', 'Romero', 'estudiante24@colegio.edu.co', 'clave123', 'Activo', 2),
('Elena', 'Ruiz', 'estudiante25@colegio.edu.co', 'clave123', 'Activo', 2),
('Álvaro', 'Torres', 'estudiante26@colegio.edu.co', 'clave123', 'Activo', 2),
('Clara', 'Ramírez', 'estudiante27@colegio.edu.co', 'clave123', 'Activo', 2),
('Luis', 'Ortiz', 'estudiante31@colegio.edu.co', 'clave123', 'Activo', 3),
('Miguel', 'Silva', 'estudiante32@colegio.edu.co', 'clave123', 'Activo', 3),
('Paula', 'Morales', 'estudiante33@colegio.edu.co', 'clave123', 'Activo', 3),
('Alba', 'Santos', 'estudiante34@colegio.edu.co', 'clave123', 'Activo', 3),
('Raúl', 'Castro', 'estudiante35@colegio.edu.co', 'clave123', 'Activo', 3),
('Natalia', 'Vega', 'estudiante36@colegio.edu.co', 'clave123', 'Activo', 3),
('Jorge', 'Ramos', 'estudiante37@colegio.edu.co', 'clave123', 'Activo', 3),
('Eva', 'Jiménez', 'estudiante41@colegio.edu.co', 'clave123', 'Activo', 4),
('Sergio', 'Herrera', 'estudiante42@colegio.edu.co', 'clave123', 'Activo', 4),
('Carla', 'Aguilar', 'estudiante43@colegio.edu.co', 'clave123', 'Activo', 4),
('Ricardo', 'Mora', 'estudiante44@colegio.edu.co', 'clave123', 'Activo', 4),
('Teresa', 'Navarro', 'estudiante45@colegio.edu.co', 'clave123', 'Activo', 4),
('Pablo', 'Gil', 'estudiante46@colegio.edu.co', 'clave123', 'Activo', 4),
('Alicia', 'Cruz', 'estudiante47@colegio.edu.co', 'clave123', 'Activo', 4),
('Fernando', 'Ibáñez', 'estudiante51@colegio.edu.co', 'clave123', 'Activo', 5),
('Inés', 'Reyes', 'estudiante52@colegio.edu.co', 'clave123', 'Activo', 5),
('Manuel', 'Parra', 'estudiante53@colegio.edu.co', 'clave123', 'Activo', 5),
('Julio', 'Esteban', 'estudiante54@colegio.edu.co', 'clave123', 'Activo', 5),
('Eva', 'Díaz', 'estudiante55@colegio.edu.co', 'clave123', 'Activo', 5),
('Sara', 'Giménez', 'estudiante56@colegio.edu.co', 'clave123', 'Activo', 5),
('Mario', 'Núñez', 'estudiante57@colegio.edu.co', 'clave123', 'Activo', 5),
('Olivia', 'Serrano', 'estudiante61@colegio.edu.co', 'clave123', 'Activo', 6),
('Oscar', 'Lara', 'estudiante62@colegio.edu.co', 'clave123', 'Activo', 6),
('Andrés', 'Castillo', 'estudiante63@colegio.edu.co', 'clave123', 'Activo', 6),
('Marina', 'Peña', 'estudiante64@colegio.edu.co', 'clave123', 'Activo', 6),
('Carmen', 'Vidal', 'estudiante65@colegio.edu.co', 'clave123', 'Activo', 6),
('Antonio', 'Benítez', 'estudiante66@colegio.edu.co', 'clave123', 'Activo', 6),
('María', 'Vargas', 'estudiante67@colegio.edu.co', 'clave123', 'Activo', 6);

INSERT INTO "horarios" ("hora_inicio","hora_fin","dia","id_materia","id_grado")
VALUES
('08:00:00','09:00:00','Lunes',1,1),
('09:00:00','10:00:00','Lunes',2,1),
('10:00:00','11:00:00','Lunes',3,1),
('11:00:00','12:00:00','Lunes',4,1),
('08:00:00','09:00:00','Martes',1,2),
('09:00:00','10:00:00','Martes',2,2),
('10:00:00','11:00:00','Martes',3,2),
('11:00:00','12:00:00','Martes',4,2),
('08:00:00','09:00:00','Miercoles',1,3),
('09:00:00','10:00:00','Miercoles',2,3),
('10:00:00','11:00:00','Miercoles',3,3),
('11:00:00','12:00:00','Miercoles',4,3),
('08:00:00','09:00:00','Jueves',1,4),
('09:00:00','10:00:00','Jueves',2,4),
('10:00:00','11:00:00','Jueves',3,4),
('11:00:00','12:00:00','Jueves',4,4),
('08:00:00','09:00:00','Viernes',1,5),
('09:00:00','10:00:00','Viernes',2,5),
('10:00:00','11:00:00','Viernes',3,5),
('11:00:00','12:00:00','Viernes',4,5),
('08:00:00','09:00:00','Viernes',1,6),
('09:00:00','10:00:00','Viernes',2,6),
('10:00:00','11:00:00','Viernes',3,6),
('11:00:00','12:00:00','Viernes',4,6);

INSERT INTO "docentes_grados" ("id_docente","id_grado")
VALUES
(3,1),
(3,2),
(4,3),
(4,4),
(5,5),
(5,6),
(6,1),
(6,2),
(7,3),
(7,4),
(8,5),
(8,6),
(9,1),
(9,2),
(10,3),
(10,4),
(11,5),
(11,6),
(12,1),
(12,2),
(1,3),
(1,4);

INSERT INTO "admins" ("nombres","apellidos","correo","clave")
VALUES
('Nombre1', 'Apellido1', 'admin@colegio.edu.co','admin123'),
('Nombre2', 'Apellido2', 'admin@colegio.edu.co','admin123'),
('Nombre3', 'Apellido3', 'admin@colegio.edu.co','admin123'),
('Nombre4', 'Apellido4', 'admin@colegio.edu.co','admin123'),
('Nombre5', 'Apellido5', 'admin@colegio.edu.co','admin123'),
('NombreCoor1', 'ApellidoCoor1', 'coordinador@colegio.edu.co','coor123');

INSERT INTO "actividades" ("titulo","descripcion","estado","nota","id_materia", "id_grado")
VALUES
('Ejercicio de Aritmética','Resolver 20 problemas de aritmética', 'No entregada', 10,1, 2),
('Taller de Geometría','Dibujar y describir figuras geométricas', 'No entregada', 5,2, 3),
('Ensayo de Literatura','Escribir un ensayo sobre una obra clásica', 'No entregada', 6,4, 6),
('Práctica de Redacción','Escribir un cuento corto', 'No entregada', 7,6, 1),
('Experimento de Biología','Realizar un experimento sobre células', 'No entregada', 8,3, 2),
('Proyecto de Física','Crear un proyecto sobre la gravedad', 'No entregada', 12,5, 1),
('Ejercicio de Aritmética','Resolver 20 problemas de aritmética', 'No entregada', 5,2, 2),
('Taller de Geometría','Resolver 20 problemas de geometría', 'No entregada', 7,2, 2);

INSERT INTO "informes" ("asunto","contenido","fecha_informe","id_actividad")
VALUES
('Informe de Aritmética','Solución de problemas de aritmética','2024-06-20',7),
('Informe de Literatura','Análisis de una obra literaria clásica','2024-06-30',9),
('Informe de Biología','Observación de células en el microscopio','2024-07-01',8),
('Informe de Física','Experimento sobre la gravedad','2024-07-05',12);
