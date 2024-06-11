-- Tabla de grados
CREATE TABLE IF NOT EXISTS "grados" (
	"id_grado" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombre" text NOT NULL,
	"codigo" text NOT NULL,
	PRIMARY KEY ("id_grado")
);

-- Tabla de docentes
CREATE TABLE IF NOT EXISTS "docentes" (
	"id_docente" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombres" text NOT NULL,
	"apellidos" text NOT NULL,
	"estado" text NOT NULL CHECK ("estado" IN ('Activo', 'Inactivo')) DEFAULT 'Activo',
	"correo" text NOT NULL,
	"clave" text NOT NULL,
	"id_materia" bigint NOT NULL,
	PRIMARY KEY ("id_docente")
);

-- Tabla de docentes de grados (tabla intermedia para la relación muchos a muchos)
CREATE TABLE IF NOT EXISTS "docentes_grados" (
    "id_docente_grado" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
    "id_docente" bigint NOT NULL,
    "id_grado" bigint NOT NULL,
    PRIMARY KEY ("id_docente_grado"),
    FOREIGN KEY ("id_docente") REFERENCES "docentes" ("id_docente") ON DELETE CASCADE,
    FOREIGN KEY ("id_grado") REFERENCES "grados" ("id_grado") ON DELETE CASCADE
);

-- Tabla de estudiantes
CREATE TABLE IF NOT EXISTS "estudiantes" (
	"id_estudiante" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombres" text NOT NULL,
	"apellidos" text NOT NULL,
	"estado" text NOT NULL CHECK ("estado" IN ('Activo', 'Inactivo', 'Suspendido', 'Expulsado')) DEFAULT 'Activo',
	"correo" text NOT NULL,
	"clave" text NOT NULL,
	"id_grado" bigint NOT NULL,
	PRIMARY KEY ("id_estudiante")
);

-- Tabla de administradores
CREATE TABLE IF NOT EXISTS "admins" (
	"id_admin" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombres" text NOT NULL,
	"apellidos" text NOT NULL,
	"correo" text NOT NULL,
	"clave" text NOT NULL,
	PRIMARY KEY ("id_admin")
);

-- Tabla de materias
CREATE TABLE IF NOT EXISTS "materias" (
	"id_materia" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombre" text NOT NULL,
	PRIMARY KEY ("id_materia")
);

-- Tabla de temas
CREATE TABLE IF NOT EXISTS "temas" (
	"id_tema" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"nombre" text NOT NULL,
	"descripcion" text NOT NULL,
	"id_materia" bigint NOT NULL,
	"id_grado" bigint NOT NULL,
	PRIMARY KEY ("id_tema")
);

-- Tabla de actividades
CREATE TABLE IF NOT EXISTS "actividades" (
	"id_actividad" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"titulo" text NOT NULL,
	"descripcion" text,
	"estado" text NOT NULL CHECK ("estado" IN ('No entregada', 'Entregada', 'Calificada', 'Vencida')) DEFAULT 'No entregada',
	"nota" int NOT NULL,
	"id_materia" bigint NOT NULL,
	"id_grado" bigint NOT NULL,
	PRIMARY KEY ("id_actividad")
);

-- Tabla de informes
CREATE TABLE IF NOT EXISTS "informes" (
	"id_informe" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"asunto" text NOT NULL,
	"contenido" text NOT NULL,
	"fecha_informe" timestamp with time zone NOT NULL,
	"id_actividad" bigint NOT NULL,
	PRIMARY KEY ("id_informe")
);

-- Tabla de materias de grados (tabla intermedia para la relación muchos a muchos)
CREATE TABLE IF NOT EXISTS "materias_grados" (
    "id_materia_grado" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
    "id_materia" bigint NOT NULL,
    "id_grado" bigint NOT NULL,
    PRIMARY KEY ("id_materia_grado"),
    FOREIGN KEY ("id_materia") REFERENCES "materias" ("id_materia") ON DELETE CASCADE,
    FOREIGN KEY ("id_grado") REFERENCES "grados" ("id_grado") ON DELETE CASCADE
);


-- Tabla de horarios
CREATE TABLE IF NOT EXISTS "horarios" (
	"id_horarios" bigint GENERATED ALWAYS AS IDENTITY NOT NULL UNIQUE,
	"hora_inicio" TIME NOT NULL,
	"hora_fin" TIME NOT NULL,
	"dia" text NOT NULL CHECK ("dia" IN ('Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) DEFAULT 'Lunes',
	"id_materia" bigint NOT NULL,
	"id_grado" bigint NOT NULL,
	PRIMARY KEY ("id_horarios")
);

-- Relaciones

-- Llaves foraneas de docentes
ALTER TABLE "docentes" ADD CONSTRAINT "docentes_fk0" FOREIGN KEY ("id_materia") REFERENCES "materias"("id_materia");

-- Llaves foraneas de temas
ALTER TABLE "temas" ADD CONSTRAINT "temas_fk0" FOREIGN KEY ("id_materia") REFERENCES "materias"("id_materia");
ALTER TABLE "temas" ADD CONSTRAINT "temas_fk1" FOREIGN KEY ("id_grado") REFERENCES "grados"("id_grado");

-- Llaves foraneas de actividades
ALTER TABLE "actividades" ADD CONSTRAINT "actividades_fk0" FOREIGN KEY ("id_materia") REFERENCES "materias"("id_materia");
ALTER TABLE "actividades" ADD CONSTRAINT "actividades_fk1" FOREIGN KEY ("id_grado") REFERENCES "grados"("id_grado");

-- Llaves foraneas de informes
ALTER TABLE "informes" ADD CONSTRAINT "informes_fk0" FOREIGN KEY ("id_actividad") REFERENCES "actividades"("id_actividad");

-- Llaves foraneas de estudiantes
ALTER TABLE "estudiantes" ADD CONSTRAINT "estudiantes_fk0" FOREIGN KEY ("id_grado") REFERENCES "grados"("id_grado");

-- Llaves foraneas de horarios
ALTER TABLE "horarios" ADD CONSTRAINT "horarios_fk0" FOREIGN KEY ("id_materia") REFERENCES "materias"("id_materia");
ALTER TABLE "horarios" ADD CONSTRAINT "horarios_fk1" FOREIGN KEY ("id_grado") REFERENCES "grados"("id_grado");

detener


-- Eliminar las constraints de las tablas
ALTER TABLE "docentes_grados" DROP CONSTRAINT "docentes_grados_fk0";
ALTER TABLE "docentes_grados" DROP CONSTRAINT "docentes_grados_fk1";
ALTER TABLE "estudiantes" DROP CONSTRAINT "estudiantes_fk0";
ALTER TABLE "materias" DROP CONSTRAINT "materias_fk0";
ALTER TABLE "temas" DROP CONSTRAINT "temas_fk0";
ALTER TABLE "actividades" DROP CONSTRAINT "actividades_fk0";
ALTER TABLE "informes" DROP CONSTRAINT "informes_fk0";
ALTER TABLE "horarios" DROP CONSTRAINT "horarios_fk0";
ALTER TABLE "horarios" DROP CONSTRAINT "horarios_fk1";

-- Eliminar las tablas
DROP TABLE IF EXISTS "docentes" CASCADE;
DROP TABLE IF EXISTS "docentes_grados" CASCADE;
DROP TABLE IF EXISTS "estudiantes" CASCADE;
DROP TABLE IF EXISTS "admins" CASCADE;
DROP TABLE IF EXISTS "materias" CASCADE;
DROP TABLE IF EXISTS "temas" CASCADE;
DROP TABLE IF EXISTS "actividades" CASCADE;
DROP TABLE IF EXISTS "informes" CASCADE;
DROP TABLE IF EXISTS "materias_grados" CASCADE;
DROP TABLE IF EXISTS "horarios" CASCADE;
DROP TABLE IF EXISTS "grados" CASCADE;