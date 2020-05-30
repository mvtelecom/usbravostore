/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usbravo.connections;

import java.sql.*;

/**
 *
 * @author mv
 */
public class ModuloConexao {

    //method to establish the connection with the database
    public static Connection conector() {
        java.sql.Connection c = null;
        //calls the library driver
        String driver = "com.mysql.jdbc.Driver";
        //storing information related to the database
        String url = "jdbc:mysql://localhost:3306/dbusbravo";
        String user = "root";
        String password = "";
        //establishing the connection to the database

        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
            return c;

        } catch (Exception e) {
            return null;
        }

    }
}
