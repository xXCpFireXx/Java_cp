import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Actividad 2
        int numero1 = 25;
        int numero2 = 79;

        System.out.println("---- ACTIVIDAD 2 ----");
        // Suma
        int suma;
        suma = numero1+numero2;
        System.out.println("La SUMA es: "+suma);

        // Resta
        int resta;
        resta = numero1-numero2;
        System.out.println("La RESTA es: "+resta);

        // Multiplicación
        int multi;
        multi = numero1*numero2;
        System.out.println("La MULTIPLICACIÓN es: "+multi);

        // División
        double division;
        division = (double) numero1/numero2;
        System.out.println("La DIVISIÓN es: "+division);

        // Módulo
        System.out.println("El MÓDULO es: "+(numero1%numero2));
        System.out.println("----------------\n");


        // Actividad 3
        System.out.println("---- ACTIVIDAD 3 ----");

        System.out.println("Ingrese su edad:");
        byte edad =  sc.nextByte();

        if (edad>=18){
            System.out.println("\nTRUE");
        } else {
            System.out.println("\nFALSE");
        }
        System.out.println("----------------\n");

        // Actividad 4
        System.out.println("---- ACTIVIDAD 4 ----");

        System.out.println("Ingresa el primer número: ");
        int n1 = sc.nextInt();

        System.out.println("\nIngresa el segundo número: ");
        int n2 = sc.nextInt();

        if (n1>0 && n2>0){
            System.out.println("\nAmbos son positivos");
        }

        if (n1>100 || n2>100){
            System.out.println("\nAl menos uno es mayor que 100");
        }

        if (n1!=n2){
            System.out.println("\nEl primero no es igual al segundo");
        }
    }
}
