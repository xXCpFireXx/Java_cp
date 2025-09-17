package app.model;

import javax.swing.*;

public class Persona {
    private String nombre;
    private byte edad;

    public Persona(String nombre, byte edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void mostrarInformacion(){
        JOptionPane.showMessageDialog(null,"Nombre Persona: "+getNombre()+"\nEdad Persona: "+getEdad());
    }
}
