/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Pedrito Alejos 
 */
public class ClaseConexion {
    
  
    //Usuario de la base de datos
    private final String USUARIO = "Portafolio_pedrito";
    //Contraseña del usuario de la base de datos
    private final String PASS = "1234";
    //SID de la base de datos, este lo registramos en la instalacion
    private final String SID = "xe";
    //Host donde se encuentra la base de datos, para nuesto caso como es local
    //se indica que esta en localhost
    private final String HOST = "localhost";
    //El puerto 1521 es el estandar para este tipo de instalaciones a menos que
    //se indicque lo contrario
    private final int PUERTO = 1521;
    //Objeto donde se almacenara nuestra conexion
    private Connection connection;

    public Connection getConnectionMetodo() {
        return connection;
    }

    
      public void registrarDriver() throws SQLException {
        OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(oracleDriver);
    }
      
          public void conectar() throws SQLException {
        //System.out.println(connection);
        if (connection == null || connection.isClosed() == true) {
            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
            registrarDriver();
            connection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);
        }
    }
    public void cerrar() throws SQLException {
        if (connection != null && connection.isClosed() == false) {
            connection.close();
        }
    }

}

