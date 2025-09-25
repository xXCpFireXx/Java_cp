package model;

import database.ConfigDB;
import database.Crud;
import entity.Coder;
import utils.InputCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements Crud {
    @Override
    public Object insert(Object object) {
        // Se abre la conexion
        Connection connection = ConfigDB.openConnection();

        // Se convierte el objecto del paramertro al tipo de objeto que necesitamos, en este caso Coder a través de un cast.
        Coder objectCoder = (Coder) object;
        try {
            String sql = "INSERT INTO coder (name, age, clan) VALUES (?,?,?)";

            // SE prepara el statemente y permitir ejecutar las setencias sql en la db
            PreparedStatement objectPrepare = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Asigna los valores en values (?,?,?) -> (1,2,3)
            objectPrepare.setString(1,objectCoder.getName());
            objectPrepare.setInt(2,objectCoder.getAge());
            objectPrepare.setString(3, objectCoder.getClan());

            // Ejecutar
            objectPrepare.execute();
            ResultSet objeRest = objectPrepare.getGeneratedKeys();

            // Recorre el resultado y asigna los id que manda la db en el objecto
            while (objeRest.next()){
                objectCoder.setId(objeRest.getInt(1));
            }

            InputCheck.showSuccessMessage("Coder was successfully added");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        ConfigDB.closeConnection();

        return objectCoder;
    }

    @Override
    public List<Object> findAll() {
        // Para guardar los coders de la BD
        List<Object> listCoders = new ArrayList<>();

        // Generar la conexión a la BD
        Connection objConnection = ConfigDB.openConnection();

        try {
            // Hacemos la sentencia SQL
            String sql = "SELECT * FROM coder";
            // Usamos el preparedStatemend que me permite hacer la consulta
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // Ejecutamos el query y lo guardamos en una variable
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                // Crear coder para poder agregarlo a la lista
                Coder objCoder = new Coder();

                objCoder.setId(objResult.getInt("id_coder"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                listCoders.add(objCoder);
            }

        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }

        ConfigDB.closeConnection();

        return listCoders;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {

        Coder coder = (Coder) object;

        // Se abre la conexion
        Connection connection = ConfigDB.openConnection();
        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM coder WHERE id_coder = ?";
            PreparedStatement objectPrepared = connection.prepareStatement(sql);
            // Se pasa el ID del coder para eliminarlo
            objectPrepared.setInt(1,coder.getId());
            // Obtiene cuantas columnas duero afectadas
            int result = objectPrepared.executeUpdate();

            if (result>0){
                isDeleted = true;
                InputCheck.showSuccessMessage("Coder successfully deleted");
            }
        } catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    public Coder findById(int id){
        // Se abre la conexion
        Connection connection = ConfigDB.openConnection();
        Coder coder = new Coder();

        try {
            String sql = "SELECT * FROM coder WHERE id_coder = ?";
            PreparedStatement objectPrepared = connection.prepareStatement(sql);
            // Se pasa el ID del coder buscarlo
            objectPrepared.setInt(1,id);

            ResultSet objResult = objectPrepared.executeQuery();

            if (objResult.next()){
                coder.setId(objResult.getInt("id_coder"));
                coder.setName(objResult.getString("name"));
                coder.setAge(objResult.getInt("age"));
                coder.setClan(objResult.getString("clan"));
            }
        } catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }

        ConfigDB.closeConnection();

        return coder;
    }
}
