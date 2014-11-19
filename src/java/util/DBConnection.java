package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SAMIPC
 */
public class DBConnection {

    InputStream input = null;
    Connection con = null;

    public Connection getLocalConnection() throws FileNotFoundException, IOException {
        try {
            //input = new FileInputStream("E:\\Education\\Graduate - Masters 2\\8. WAA\\labs\\project\\original\\WAADMV2\\src\\java\\util\\database.properties");
            input = getClass().getClassLoader().getResourceAsStream("/util/database.properties");
            Properties prop = new Properties();
            prop.load(input);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("db.host") + "/" + prop.getProperty("db.dbname"), prop.getProperty("db.user"), prop.getProperty("db.password"));
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException ingetConnection, " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException in getConnection, " + e.getMessage());
        }
        return con;
    }

    public void setConnectionClose() throws SQLException {
        con.close();
    }

}
