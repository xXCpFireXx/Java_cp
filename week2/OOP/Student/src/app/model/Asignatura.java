package app.model;

public class Asignatura {
    private String nombreAsignatura;
    private double nota;

    public Asignatura(String nombre, double nota) {
        this.nombreAsignatura = nombre;
        this.nota = nota;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public double getNota() {
        return nota;
    }

    public String estado() {
        String respuesta = "";

        if (nota >= 3.5){
            respuesta = "Aprobada";
        } else if (nota < 3.5){
            respuesta = "Reprobada";
        }
        return respuesta;
    }
}