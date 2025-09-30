package Model;

import Database.ConfigDB;
import Database.ICrud;
import Entity.Product;
import Utils.InputCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel implements ICrud<Product> {
    int totalOperations = 0;

    @Override
    public Product insert(Product product) {
        String sql = "INSERT INTO products (name_product, price , stock_product) VALUES (?,?,?)";
        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            objPrepare.setString(1, product.getName());
            objPrepare.setDouble(2, product.getPrice());
            objPrepare.setInt(3, product.getStock());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while (objRest.next()){
                product.setId(objRest.getInt(1));
            }
            InputCheck.showSuccessMessage("Product was succesfully added");
            totalOperations ++;
        }catch (Exception error){
            InputCheck.showWarningMessage(error.getMessage(),"Error");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {

        List<Product> listProducts = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql)) {

            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Product objProduct = new Product();
                objProduct.setId(objResult.getInt("id_product"));
                objProduct.setName(objResult.getString("name_product"));
                objProduct.setPrice(objResult.getDouble("price"));
                objProduct.setStock(objResult.getInt("stock_product"));

                listProducts.add(objProduct);
            }
            totalOperations++;
        }catch (Exception error){
            InputCheck.showWarningMessage(error.getMessage(),"Error");
        }
        return listProducts;
    }

    @Override
    public boolean update(Product product) {
        boolean isUpdated = false;

        String sql = "UPDATE products SET price = ?, stock_product = ? where id_product = ?";
        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            objPrepare.setDouble(1, product.getPrice());
            objPrepare.setInt(2, product.getStock());
            objPrepare.setInt(3, product.getId());

            int result = objPrepare.executeUpdate();

            if (result > 0){
                isUpdated= true;
                InputCheck.showSuccessMessage(product.getName()+" was updated");
                totalOperations ++;
            }
        }catch (Exception error){
            InputCheck.showWarningMessage(error.getMessage(),"Error");
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Product product) {
        boolean isDeleted = false;

        String sql = "DELETE FROM products where id_product = ?";
        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            objPrepare.setInt(1, product.getId());

            int result = objPrepare.executeUpdate();

            if (result > 0){
                isDeleted= true;
                InputCheck.showSuccessMessage(product.getName()+" was deleted");
                totalOperations ++;
            }
        }catch (Exception error){
            InputCheck.showWarningMessage(error.getMessage(),"Error");
        }
        return isDeleted;
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id_product = ?";

        Product objProduct = null;

        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql)) {

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()) {
                objProduct = new Product(); // Se debe inicializar
                objProduct.setId(objResult.getInt("id_product"));
                objProduct.setName(objResult.getString("name_product"));
                objProduct.setPrice(objResult.getDouble("price"));
                objProduct.setStock(objResult.getInt("stock_product"));
            }

        } catch (SQLException error) {
            System.err.println("Error searching ID of product: " + error.getMessage());
        }
        return objProduct;
    }

    @Override
    public List<Product> findByName(String name) {

        String sql = "SELECT * FROM products WHERE name_product LIKE ?";
        List<Product> listProductsSearched = new ArrayList<>();

        try (Connection objConnection = ConfigDB.openConnection();
             PreparedStatement objPrepare = objConnection.prepareStatement(sql)) {

            objPrepare.setString(1, "%" + name + "%");

            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Product objProduct = new Product();
                objProduct.setId(objResult.getInt("id_product"));
                objProduct.setName(objResult.getString("name_product"));
                objProduct.setPrice(objResult.getDouble("price"));
                objProduct.setStock(objResult.getInt("stock_product"));

                listProductsSearched.add(objProduct);
            }
            totalOperations++;
        } catch (SQLException error) {
            System.err.println("Error searching name of product: " + error.getMessage());
        }
        return listProductsSearched;
    }

}
