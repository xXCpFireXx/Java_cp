package Repaso;

import java.util.Scanner;

public class For {
    public static void main(String[] args){

        // Patrón en pirámide.
        System.out.println("- Patrón en pirámide -");
        String space = " ";
        String x = "*";
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = k; j < 3; j++) {
                System.out.print(space);
            }
            System.out.println(x);
            x+="**";
            k++;
        }
    }
}
