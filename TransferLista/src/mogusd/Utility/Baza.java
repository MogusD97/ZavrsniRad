/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogusd.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author domin
 */
public class Baza {
    private static Baza instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost/transferlista?serverTimezone=UTC&"
            + "useUnicode=true&characterEncoding=utf-8";
    private String username = "edunova";
    private String password = "edunova";

    private Baza() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Baza getInstance() throws SQLException {
        if (instance == null) {
            instance = new Baza();
        } else if (instance.getConnection().isClosed()) {
            instance = new Baza();
        }

        return instance;
    }

    public Connection getConnection(String jdbcmysqllocalhost3306transferlista, String root, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
