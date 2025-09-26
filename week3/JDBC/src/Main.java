import controller.CoderController;
import database.ConfigDB;
import utils.InputCheck;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String optionUser ="";
        do {
            optionUser = JOptionPane.showInputDialog(null,
                    """
                    1. Create
                    2. List
                    3. Delete
                    4. Update
                    5. Exit
                    """);

            switch (optionUser){
                case "1":
                    CoderController.create();
                    break;
                case "2":
                    CoderController.getAll();
                    break;
                case  "3":
                    CoderController.delete();
                    break;
                case "4":
                    CoderController.update();
                    break;
                default:
                    InputCheck.showWarningMessage("Invalid option","Error");
                    break;
            }

        } while (!optionUser.equals("5"));

    }
}
