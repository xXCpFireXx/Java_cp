package Controller;
import Entity.Product;
import Model.ProductModel;
import Utils.InputCheck;

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

        Product = (Product) ProductModel.insert(Product);

        InputCheck.showInfoMessage(Product.toString(),"Product");
    }

}
