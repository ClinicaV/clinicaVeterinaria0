    package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    static String bd = "clinicaVeterinaria";
    static String user = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    Connection conn = null;

    public Conexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Exito en la conexion con la Base de Datos");
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse a la Base de Datos");

        }

    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() throws Exception {

        conn.close();
    }
}
