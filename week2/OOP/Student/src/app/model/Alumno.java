package app.model;

public class Alumno extends Persona{

    private Asignatura [] asignaturas = new Asignatura[4];

    public Alumno(String nombre, byte edad) {
        super(nombre, edad);
    }

    public void agregarAsignatura(Asignatura asignatura){

    }

    public double calcularPromedio(){
        return 0.0;
    }

}
