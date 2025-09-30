package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection objConnection = null;

    public static Connection openConnection(){

        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");

            // URL de conexión con pooling (ojo al puerto 6543)
            String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres";
            String user = "postgres.kykvcrzsqbqpdmoeqltr";  // 👈 este es tu usuario
            String password = "Java*123";           // 👈 reemplázalo con el de tu Supabase

            // Conexión
            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado a Supabase (pooling)");

        } catch (ClassNotFoundException error) {
            System.out.println("Driver PostgreSQL no encontrado: " + error.getMessage());
        } catch (SQLException error){
            System.out.println("❌ Error al conectar: " + error.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("🔒 Conexión cerrada");
            }
        } catch (SQLException error){
            System.out.println("❌ Error al cerrar conexión: " + error.getMessage());
        }
    }
}
