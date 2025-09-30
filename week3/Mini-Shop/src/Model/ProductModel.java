package Model;

import Database.ConfigDB;
import Database.ICrud;
import Entity.Product;
import Utils.InputCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductModel implements ICrud {
    int totalOperations = 0;

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Product product = (Product) obj;
        try{
            String sql = "INSERT INTO products (name_product, price , stock_product) VALUES (?,?,?)";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

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
        ConfigDB.closeConnection();
        return product;
    }

    @Override
    public List<Object> findAll() {

        List<Object> listProducts = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();
        try {

            String sql = "SELECT * FROM products";
            // Usamos el preparedStatemend que me permite hacer la consulta
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

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
        ConfigDB.closeConnection();

        return listProducts;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
