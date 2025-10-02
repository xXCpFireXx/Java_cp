package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static Connection openConnection() {

        try {
            // Le damos las credenciales para nuestra bd
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "school";
            String url = "jdbc:mysql://localhost:3306/" + database;
            String user = "root";
            String password = "Qwe.123*";

            // Establecemos la conexion
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("me conecté exitosamente");

        } catch (ClassNotFoundException error) {
            System.out.println("driver no instalado" + error.getMessage());
        } catch (SQLException error) {
            System.out.println("error al conectar el la base de datos" + error.getMessage());
        }
        return objConnection;
    }
}