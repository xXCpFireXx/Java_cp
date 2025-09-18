package app.model;

import javax.swing.*;

public class Alumno extends Persona {
    private Asignatura[] asignaturas = new Asignatura[4];
    private int contadorAsignaturas = 0;

    public Alumno(String nombre, byte edad) {
        super(nombre, edad);
    }

    public void agregarAsignatura(Asignatura asignatura) {
        if (contadorAsignaturas >= 4) {
            JOptionPane.showMessageDialog(null, "No puedes agregar más asignaturas a "+getNombre()+". El límite es de 4 alcanzado.","Límite alcanzado",JOptionPane.WARNING_MESSAGE);
        }

        for (int i = 0; i < contadorAsignaturas; i++) {
            if (asignaturas[i].getNombreAsignatura().equals(asignatura.getNombreAsignatura())) {
                JOptionPane.showMessageDialog(null, "La asignatura " + asignatura.getNombreAsignatura() + " ya se registró para "+getNombre(),"Asignatura registrada",JOptionPane.WARNING_MESSAGE);
            }
        }

        asignaturas[contadorAsignaturas] = asignatura;
        contadorAsignaturas++;
    }

    public double calcularPromedio() {
        double suma = 0.0;
        double promedio;
        if (contadorAsignaturas == 0) {
            return 0.0;
        }

        for (int i = 0; i < contadorAsignaturas; i++) {
            suma += asignaturas[i].getNota();
        }

        promedio = suma / contadorAsignaturas;

        return promedio;
    }

    @Override
    public void mostrarInformacion() {
        StringBuilder informacionStudiante = new StringBuilder();
        informacionStudiante.append("Nombre: ").append(getNombre()).append("\n");
        informacionStudiante.append("Edad: ").append(getEdad()).append("\n");

        informacionStudiante.append("\n------ Asignaturas ------\n");
        for (int i = 0; i < contadorAsignaturas; i++) {
            informacionStudiante.append(asignaturas[i].getNombreAsignatura()).append(": ").append(asignaturas[i].getNota()).append(" --> [").append(asignaturas[i].estado()).append("]\n");
        }

        informacionStudiante.append(String.format("\nPromedio final: %.2f", calcularPromedio()));
        JOptionPane.showMessageDialog(null, informacionStudiante.toString(),getNombre(),JOptionPane.INFORMATION_MESSAGE);
    }

    public int getContadorAsignaturas() {
        return contadorAsignaturas;
    }

    public void setContadorAsignaturas(int contadorAsignaturas) {
        this.contadorAsignaturas = contadorAsignaturas;
    }
}