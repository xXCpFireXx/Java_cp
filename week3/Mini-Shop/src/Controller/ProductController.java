package Controller;
import Entity.Product;
import Model.ProductModel;
import Utils.InputCheck;

import javax.swing.*;
import java.util.List;

public class ProductController {

    public static void create(){
        // Usamos el modelo
        ProductModel ProductModel = new ProductModel();

        // Pedir los datos al usuario
        String name = InputCheck.requestString("Enter product name","Name must not empty");
        double price = InputCheck.requestDouble("Enter product price","Price must not empty");
        int stock = InputCheck.requestInteger("Enter product stock","Stock must not empty");

        Product Product = new Product();

        Product.setName(name);
        Product.setPrice(price);
        Product.setStock(stock);

        Product = ProductModel.insert(Product);

        InputCheck.showInfoMessage(Product.toString(),"Product");
    }

    public static void getAll(){
        ProductModel ProductModel = new ProductModel();
        StringBuilder listProducts = new StringBuilder();

        for (Product i : ProductModel.findAll()){
            listProducts.append(i.toString()).append("\n");
        }
        InputCheck.showInfoMessage(String.valueOf(listProducts),"List Products");
    }

    public static void update(int i){
        // Llamamos al modelo para acceder a los metodos
        ProductModel ProductModel = new ProductModel();
        getAll();

        int idUpdate = InputCheck.requestInteger("Enter ID to update","ID must not be empty");
        Product product = ProductModel.findById(idUpdate);

        // condicional para verificar si existe
        if (product == null){
            InputCheck.showWarningMessage("Product not found","Product not found");
        }else{
            if (i==3){
                product.setPrice( Double.parseDouble(JOptionPane.showInputDialog("Enter new product price", product.getPrice())));
            }else {
                product.setStock(Integer.parseInt(JOptionPane.showInputDialog("Enter new product stock", product.getStock())));
            }
            ProductModel.update(product);

        }
    }

    public static void delete(){

        ProductModel ProductModel = new ProductModel();
        getAll();

        int idDelete = InputCheck.requestInteger("Enter product ID to delete","ID must not be empty");
        Product product = ProductModel.findById(idDelete);

        if (product == null){
            InputCheck.showWarningMessage("Product not found","Product not found");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (confirm == 0) ProductModel.delete(product);
        }

    }

    public static void search(){
        ProductModel ProductModel = new ProductModel();
        StringBuilder listProducts = new StringBuilder();

        String name = InputCheck.requestString("Enter product name to search","Name must not be empty");

        // condicional para verificar si existe
        for (Product i : ProductModel.findByName(name)){
            listProducts.append(i.toString()).append("\n");
        }
        InputCheck.showInfoMessage(String.valueOf(listProducts),"List Products");
    }

    public static void exit(){
        ProductModel ProductModel = new ProductModel();
        InputCheck.showInfoMessage("total number of transactions done during the session: "+ProductModel.getTotalOperations(),"Exit");
    }
}
