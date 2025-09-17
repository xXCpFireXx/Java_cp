package app;

import app.model.Alumno;
import app.model.Asignatura;

public class Aplicacion {
    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Juan Perez", (byte)20);
        Alumno alumno2 = new Alumno("Maria Gomez", (byte)19);
        Alumno alumno3 = new Alumno("Carlos Lopez", (byte)21);

        alumno1.agregarAsignatura(new Asignatura("Matemáticas", 4.0));
        alumno1.agregarAsignatura(new Asignatura("Física", 3.8));
        alumno1.agregarAsignatura(new Asignatura("Programación", 4.5));

        alumno2.agregarAsignatura(new Asignatura("Matemáticas", 3.0));
        alumno2.agregarAsignatura(new Asignatura("Química", 2.8));
        alumno2.agregarAsignatura(new Asignatura("Historia", 4.2));

        alumno3.agregarAsignatura(new Asignatura("Literatura", 3.5));
        alumno3.agregarAsignatura(new Asignatura("Física", 2.5));
        alumno3.agregarAsignatura(new Asignatura("Programación", 4.8));

        alumno1.mostrarInformacion();
        alumno2.mostrarInformacion();
        alumno3.mostrarInformacion();
    }

}
