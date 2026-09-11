package Ejercicio_3;

/**
 *
 * @author Dario Curell
 */

public class Main {

    public static void main(String[] args) {

        // Crear la universidad

        Universidad universidad = new Universidad(
                "Universidad Nacional"
        );

        // 1. Crear 3 profesores

        Profesor profesor1 = new Profesor(
                "P001",
                "Ariel Enferrel",
                "Programacion"
        );

        Profesor profesor2 = new Profesor(
                "P002",
                "Tola Luis Miguel",
                "Bases de Datos"
        );

        Profesor profesor3 = new Profesor(
                "P003",
                "Clarisa Stefanich",
                "Probabilidad y Estadística"
        );

        // 1. Crear 5 cursos

        Curso curso1 = new Curso(
                "C001",
                "Programacion II"
        );

        Curso curso2 = new Curso(
                "C002",
                "Bases de Datos"
        );

        Curso curso3 = new Curso(
                "C003",
                "Programacion III"
        );

        Curso curso4 = new Curso(
                "C004",
                "Probabilidad y Estadística"
        );

        Curso curso5 = new Curso(
                "C005",
                "Arquitectura y Sistemas Operativos"
        );

        // 2. Agregar profesores y cursos a la universidad

        universidad.agregarProfesor(profesor1);
        universidad.agregarProfesor(profesor2);
        universidad.agregarProfesor(profesor3);

        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);

        // 3. Asignar profesores a cursos

        System.out.println("===== ASIGNACION DE PROFESORES =====");

        universidad.asignarProfesorACurso("C001", "P001");
        universidad.asignarProfesorACurso("C002", "P002");
        universidad.asignarProfesorACurso("C003", "P001");
        universidad.asignarProfesorACurso("C004", "P003");
        universidad.asignarProfesorACurso("C005", "P003");

        // 4. Listar cursos con sus profesores

        System.out.println("\n===== LISTADO DE CURSOS =====");

        universidad.listarCursos();

        // 4. Listar profesores con sus cursos

        System.out.println("\n===== LISTADO DE PROFESORES =====");

        universidad.listarProfesores();

        // 5. Cambiar el profesor de un curso

        System.out.println("\n===== CAMBIO DE PROFESOR =====");

        System.out.println(
                "Antes: C001 pertenece a "
                + curso1.getProfesor().getNombre()
        );

        universidad.asignarProfesorACurso("C001", "P002");

        System.out.println(
                "Despues: C001 pertenece a "
                + curso1.getProfesor().getNombre()
        );

        // Verificar ambos lados de la relacion

        System.out.println("\nCursos del profesor anterior (P001):");

        profesor1.listarCursos();

        System.out.println("\nCursos del nuevo profesor (P002):");

        profesor2.listarCursos();

        // 6. Eliminar un curso

        System.out.println("\n===== ELIMINAR CURSO C005 =====");

        universidad.eliminarCurso("C005");

        System.out.println("\nCursos del profesor P003:");

        profesor3.listarCursos();

        // 7. Eliminar un profesor

        System.out.println("\n===== ELIMINAR PROFESOR P003 =====");

        universidad.eliminarProfesor("P003");

        System.out.println("\nCursos que tenia el profesor P003:");

        System.out.println(
                "C004 - Profesor: "
                + (curso4.getProfesor() == null
                        ? "Sin asignar"
                        : curso4.getProfesor().getNombre())
        );

        // 8. Reporte de cantidad de cursos por profesor

        System.out.println("\n===== REPORTE DE CURSOS POR PROFESOR =====");

        System.out.println(
                profesor1.getNombre()
                + ": "
                + profesor1.getCursos().size()
                + " curso(s)"
        );

        System.out.println(
                profesor2.getNombre()
                + ": "
                + profesor2.getCursos().size()
                + " curso(s)"
        );

        System.out.println(
                profesor3.getNombre()
                + ": "
                + profesor3.getCursos().size()
                + " curso(s)"
        );
    }
}