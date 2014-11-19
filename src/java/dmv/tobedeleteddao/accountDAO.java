/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddao;

import dmv.tobedeleteddomain.accountEntity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author SAMIPC
 */
public class accountDAO {

    Statement stmt = null;
    DBConnection dbc;
    Connection con;

    public accountDAO() throws IOException {
        dbc = new DBConnection();
        con = dbc.getLocalConnection();
    }

    public void addAccount(accountEntity account) throws SQLException {

        stmt = con.createStatement();

        String query = "insert into account (firstName,lastName,dateOfBirth,ssn,gender,eyecolor,height,weight,username,password,addressId) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, account.getFirstName());
        preparedStmt.setString(2, account.getLastName());
        
        java.sql.Date sqlDate = null;
        if(account.getDateOfBirth() != null)
            sqlDate = new java.sql.Date(account.getDateOfBirth().getTime());
        preparedStmt.setDate(3, sqlDate);
        preparedStmt.setInt(4, account.getSsn());
        preparedStmt.setString(5, account.getGender());
        preparedStmt.setString(6,account.getEyeColor());
        preparedStmt.setDouble(7,account.getHeight());
        preparedStmt.setDouble(8,account.getWeight());
        preparedStmt.setString(9, account.getUserName());
        preparedStmt.setString(10, account.getPassword());
        preparedStmt.setInt(11, account.getAddressId());

        preparedStmt.executeUpdate();
    }
    
    public int getAccountId(int ssn) throws SQLException {
        ArrayList<Integer> ids = new ArrayList();
        stmt = con.createStatement();
        String query = "select id from account where ssn = "+ ssn;
        ResultSet result = stmt.executeQuery(query);

        while (result.next()) {
            ids.add(Integer.parseInt(result.getString(1)));
        }       
        return ids.get(0);
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

}
