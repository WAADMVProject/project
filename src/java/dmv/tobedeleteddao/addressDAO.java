/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddao;

import dmv.tobedeleteddomain.addressEntity;
import dmv.tobedeleteddomain.addressEntity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author SAMIPC
 */
public class addressDAO {

    Statement stmt = null;
    DBConnection dbc;
    Connection con;

    public addressDAO() throws IOException {
        dbc = new DBConnection();
        con = dbc.getLocalConnection();
    }

    public int addAddress(addressEntity address) throws SQLException {

        stmt = con.createStatement();       
        String query = "insert into address (streetAddress,city,state,zip) values ('" + address.getStreetAddress() + "',"
                + "'" + address.getCity() + "',"
                + "'" + address.getState() + "',"
                + "'" + address.getZip() + "')";
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

}
