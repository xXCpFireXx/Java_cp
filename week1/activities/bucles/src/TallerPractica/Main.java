package TallerPractica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Arrays
        int [] numbers = {36,25,14,89,10};

        System.out.println("Números multiplicados por 2: ");
        for (int number : numbers) {
            if (number%2==0){
                System.out.println(number);
            }
        }

        int [] newNumbers = new int[6];
        int input = 0;
        System.out.println("\n------ Ingresa 6 números ------");

        for (int i = 0; i < 6; i++) {
            System.out.println("Ingresa el número "+(i+1)+":");
            input = sc.nextInt();
            newNumbers[i] = input;
            System.out.println("");
        }

        System.out.println("Los números ingresados son:");
        for (int number : newNumbers) {
            System.out.println(number);
        }
        System.out.println("\n-------------------\n");

        // ArrayList
        ArrayList<String> mates = new ArrayList<>();
        mates.add("Camila");
        mates.add("Pablo");
        mates.add("Daniela");
        mates.add("Brisbany");

        for (String name : mates) {
            System.out.println("Hola, "+name);
        }

        System.out.println("\n-------------------\n");

        // HashMap
        HashMap<Integer, String> user = new HashMap<>();
        user.put(11254569,"Camila");
        user.put(33654211,"Pablo");
        user.put(39854921,"Daniela");
        user.put(33651271,"Brisbany");

        for (var entry : user.entrySet()) {
            System.out.println("Documento: " + entry.getKey() + " → Nombre: " + entry.getValue());
        }
    }
}
