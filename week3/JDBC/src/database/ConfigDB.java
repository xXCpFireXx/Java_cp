package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/user_management";
            String user = "root";
            String password = "Qwe.123*";

            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Conexión Exitosa");
        } catch (ClassNotFoundException e){
            System.out.println("Driver no instalado "+e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al conectarse a la base de datos "+e.getMessage());
        }
        return objConnection;
    }
}
