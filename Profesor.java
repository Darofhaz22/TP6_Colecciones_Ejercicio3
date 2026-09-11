package Ejercicio_3;

/**
 *
 * @author Dario Curell
 */

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso c) {

        if (c == null) {
            return;
        }

        if (!cursos.contains(c)) {
            cursos.add(c);
        }

        if (c.getProfesor() != this) {
            c.setProfesor(this);
        }
    }

    public void eliminarCurso(Curso c) {

        if (c == null) {
            return;
        }

        cursos.remove(c);

        if (c.getProfesor() == this) {
            c.setProfesor(null);
        }
    }

    public void listarCursos() {

        if (cursos.isEmpty()) {
            System.out.println("El profesor no tiene cursos asignados.");
            return;
        }

        for (Curso curso : cursos) {
            System.out.println(
                    "Codigo: " + curso.getCodigo()
                    + " - Nombre: " + curso.getNombre()
            );
        }
    }

    public void mostrarInfo() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cantidad de cursos: " + cursos.size());
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}