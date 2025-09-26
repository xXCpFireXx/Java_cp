import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            // aqui en el main solo llamamos al controller para pedir los datos
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. create coder
                    2. get all coders
                    3. delete coder
                    4. update coder
                    """);
            switch (option){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
        }while (!option.equals("5"));


    }
}