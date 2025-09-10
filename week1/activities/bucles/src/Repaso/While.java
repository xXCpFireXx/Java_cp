package Repaso;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class While {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Inverso de un número
        System.out.println("- Inverso de un número -");
        System.out.println("Ingresa un número entero: ");
        int number = sc.nextInt();

        String numberString = Integer.toString(number); // Convierte a String el int.
        char [] numberArray = numberString.toCharArray(); // Convierte el String en un array de caracteres.
        int lastChar = (numberString.length()) - 1; // Se busca el indice del ultimo caracter en el array.
        int counter = 0;
        String reverseNumber = "";

        while (counter < numberString.length()){
             reverseNumber += numberArray[lastChar];
            lastChar--;
            counter++;
        }

        System.out.println("El número al reves es: "+reverseNumber);

        if (numberString.equals(reverseNumber)){
            System.out.println("El número "+numberString+" es Capicúa.");
        }


    }
}
