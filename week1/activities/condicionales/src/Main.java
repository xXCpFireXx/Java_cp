import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Actividad 5
        System.out.println("--------- ACTIVIDAD 5 -----------");
        System.out.println("Ingresa un número: ");
        int numero = sc.nextInt();

        if (numero>0){
            System.out.println("Es positivo");
        } else {
            if (numero<0){
                System.out.println("Es negativo");
            }else {
                System.out.println("Es cero");
            }
        }
        System.out.println("-------------------------------\n");

        // Actividad 6
        System.out.println("--------- ACTIVIDAD 6 -----------");

        System.out.println("Ingresa tu edad: ");
        byte edad = sc.nextByte();

        if (edad>=18){
            System.out.println("Adulto");
        } else if (edad>=12 && edad<=17) {
            System.out.println("Adolescente");
        } else {
            System.out.println("Niño");
        }

        System.out.println("-------------------------------\n");

        // Actividad 7
        System.out.println("--------- ACTIVIDAD 7 -----------");
        System.out.println("Ingresa un número del 1 al 7: ");
        byte opcion = sc.nextByte();

        switch (opcion){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número no valido");
                break;
        }
    }
}