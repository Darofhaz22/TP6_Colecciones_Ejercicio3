package Ejercicio_3;

/**
 *
 * @author Dario Curell
 */

public class Curso {

    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    public void setProfesor(Profesor nuevoProfesor) {

        if (this.profesor == nuevoProfesor) {
            return;
        }

        if (this.profesor != null) {

            Profesor profesorAnterior = this.profesor;

            this.profesor = null;

            profesorAnterior.eliminarCurso(this);
        }

        this.profesor = nuevoProfesor;

        if (nuevoProfesor != null) {
            nuevoProfesor.agregarCurso(this);
        }
    }

    public void mostrarInfo() {

        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);

        if (profesor != null) {
            System.out.println(
                    "Profesor: " + profesor.getNombre()
            );
        } else {
            System.out.println("Profesor: Sin asignar");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}