package controller;

import entity.Coder;
import model.CoderModel;
import utils.InputCheck;

import javax.swing.*;

public class CoderController {

    public static void create(){
        CoderModel coderModel = new CoderModel();

        String name = InputCheck.requestString("Enter a name","Name empty");
        int age = InputCheck.requestInteger("Enter an age","Age empty");
        String clan = InputCheck.requestString("Enter a clan","Clan empty");

        Coder coder = new Coder();
        coder.setName(name);
        coder.setAge(age);
        coder.setClan(clan);

        coder = (Coder) coderModel.insert(coder);

        InputCheck.showSuccessMessage(coder.toString());
    }

    public static void getAll() {
        CoderModel coderModel = new CoderModel();
        String listCoders = "List coders\n";
        for (Object i : coderModel.findAll()) {
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString() + "\n";
        }
        InputCheck.showInfoMessage(listCoders,"List of Coders");
    }

    public static void delete(){
        CoderModel coderModel = new CoderModel();

        int id = InputCheck.requestInteger("Enter the ID to delete","ID empty");
        Coder coder = coderModel.findById(id);

        if (coder == null){
            InputCheck.showWarningMessage("Coder no found", "No found");
        } else {
            int confirm = InputCheck.requestConfirm("Are you sure to delete this coder?","sure?");
            if (confirm == 0)coderModel.delete(coder);
        }
    }

    public static void update(){
        CoderModel coderModel = new CoderModel();
        getAll();

        int id = InputCheck.requestInteger("Enter the ID to delete","ID empty");
        Coder coder = coderModel.findById(id);

        if (coder == null){
            InputCheck.showWarningMessage("Coder no found", "No found");
        } else {
            coder.setName(JOptionPane.showInputDialog(null,"Enter new name", coder.getName()));
            coder.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter new age", coder.getAge())));
            coder.setClan(JOptionPane.showInputDialog(null,"Enter new clan", coder.getClan()));

            coderModel.update(coder);
        }
    }
}
