/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import resources.ConfigureProperties;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alex
 */
public class Conexion {

    private final static String driver = ConfigureProperties.getProperty("driverServer");
    private final static String url = ConfigureProperties.getProperty("urlServer");
    private final static String user = ConfigureProperties.getProperty("userServer");
    private final static String pass = ConfigureProperties.getProperty("passServer");

    public static Connection getConexion() throws ConexionException {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ConexionException("error al conectar la BD" + e.getMessage());
        }
        return con;
    }
}
