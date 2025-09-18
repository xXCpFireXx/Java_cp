package app;

import app.model.Alumno;
import app.model.Asignatura;

public class Aplicacion {
    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Camila", (byte)16);
        Alumno alumno2 = new Alumno("Juan Pablo", (byte)17);
        Alumno alumno3 = new Alumno("Brisbany", (byte)15);

        alumno1.agregarAsignatura(new Asignatura("Religión", 4.2));
        alumno1.agregarAsignatura(new Asignatura("Álgebra", 3.8));
        alumno1.agregarAsignatura(new Asignatura("Sociales", 4.6));
        alumno1.agregarAsignatura(new Asignatura("Español", 3.6));

        alumno2.agregarAsignatura(new Asignatura("Álgebra", 3.8));
        alumno2.agregarAsignatura(new Asignatura("Química", 4.8));
        alumno2.agregarAsignatura(new Asignatura("Sociales", 3.2));
        alumno2.agregarAsignatura(new Asignatura("Español", 3.4));

        alumno3.agregarAsignatura(new Asignatura("Español", 3.9));
        alumno3.agregarAsignatura(new Asignatura("Álgebra", 4.5));
        alumno3.agregarAsignatura(new Asignatura("Sociales", 4.8));
        alumno3.agregarAsignatura(new Asignatura("Religión", 4.2));

        alumno1.mostrarInformacion();
        alumno2.mostrarInformacion();
        alumno3.mostrarInformacion();
    }

}
