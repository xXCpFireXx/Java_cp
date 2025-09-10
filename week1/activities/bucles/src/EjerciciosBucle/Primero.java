package EjerciciosBucle;

import java.util.Scanner;

public class Primero {
    public static void main(String[] args){
        // Crea una aplicación que pida un número y calcule su factorial.

        Scanner sc = new Scanner(System.in);
        System.out.println("-------- Factorial --------\n");
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int factorial = 1;

        for (int i = 1; i < number+1; i++) {
            factorial *= i;
        }
        System.out.println("\nFactorial "+number+"! = "+factorial);
    }
}
