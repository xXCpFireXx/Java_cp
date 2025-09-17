package app;

import app.model.Alumno;
import app.model.Asignatura;

public class Aplicacion {
    public static void main(String[] args) {
        // 1. Crear alumnos
        Alumno alumno1 = new Alumno("Laura", (byte) 20);
        Alumno alumno2 = new Alumno("Andrés", (byte) 22);
        Alumno alumno3 = new Alumno("Sofía", (byte) 19);

        // 2. Agregar asignaturas
        alumno1.agregarAsignatura(new Asignatura("Matemáticas", 4.5));
        alumno1.agregarAsignatura(new Asignatura("Historia", 3.0));

        alumno2.agregarAsignatura(new Asignatura("Física", 3.8));
        alumno2.agregarAsignatura(new Asignatura("Química", 4.2));

        alumno3.agregarAsignatura(new Asignatura("Lengua", 2.9));
        alumno3.agregarAsignatura(new Asignatura("Arte", 3.6));

        // 3. Mostrar información (polimorfismo)
//        System.out.println(alumno1.mostrarInformacion());
//        System.out.println(alumno2.mostrarInformacion());
//        System.out.println(alumno3.mostrarInformacion());
    }

}
