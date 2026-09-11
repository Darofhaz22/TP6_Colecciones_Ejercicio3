package Ejercicio_3;

/**
 *
 * @author Dario Curell
 */

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p) {

        if (p != null && !profesores.contains(p)) {
            profesores.add(p);
        }
    }

    public void agregarCurso(Curso c) {

        if (c != null && !cursos.contains(c)) {
            cursos.add(c);
        }
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {

        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso != null && profesor != null) {

            curso.setProfesor(profesor);

            System.out.println("Profesor asignado correctamente.");

        } else {
            System.out.println(
                    "No se encontro el curso o el profesor."
            );
        }
    }

    public void listarProfesores() {

        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        for (Profesor profesor : profesores) {

            profesor.mostrarInfo();

            System.out.println("Cursos que dicta:");

            profesor.listarCursos();

            System.out.println("-------------------------");
        }
    }

    public void listarCursos() {

        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        for (Curso curso : cursos) {

            curso.mostrarInfo();

            System.out.println("-------------------------");
        }
    }

    public Profesor buscarProfesorPorId(String id) {

        for (Profesor profesor : profesores) {

            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }

        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {

        for (Curso curso : cursos) {

            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }

        return null;
    }

    public void eliminarCurso(String codigo) {

        Curso curso = buscarCursoPorCodigo(codigo);

        if (curso != null) {

            curso.setProfesor(null);

            cursos.remove(curso);

            System.out.println("Curso eliminado correctamente.");

        } else {
            System.out.println(
                    "No se encontro un curso con ese codigo."
            );
        }
    }

    public void eliminarProfesor(String id) {

        Profesor profesor = buscarProfesorPorId(id);

        if (profesor != null) {

            List<Curso> cursosDelProfesor =
                    new ArrayList<>(profesor.getCursos());

            for (Curso curso : cursosDelProfesor) {
                curso.setProfesor(null);
            }

            profesores.remove(profesor);

            System.out.println(
                    "Profesor eliminado correctamente."
            );

        } else {
            System.out.println(
                    "No se encontro un profesor con ese ID."
            );
        }
    }

    public String getNombre() {
        return nombre;
    }
}