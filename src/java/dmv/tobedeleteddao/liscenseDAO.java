/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddao;

import dmv.tobedeleteddomain.liscenseEntity;
import dmv.tobedeleteddomain.liscenseEntity;
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
public class liscenseDAO {

    Statement stmt = null;
    DBConnection dbc;
    Connection con;

    public liscenseDAO() throws IOException {
        dbc = new DBConnection();
        con = dbc.getLocalConnection();
    }

    public void addLiscense(liscenseEntity liscense) throws SQLException {

        stmt = con.createStatement();

        String query = "insert into liscense (behindTheWheelExamScore,issuanceDate,expirationDate,permitId) values (?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, liscense.getBehindTheWheelExamScore());

        java.sql.Date issueDate = null;
        if (liscense.getIssuanceDate() != null) {
            issueDate = new java.sql.Date(liscense.getIssuanceDate().getTime());
        }
        preparedStmt.setDate(2, issueDate);

        java.sql.Date expDate = null;
        if (liscense.getExpirationDate() != null) {
            expDate = new java.sql.Date(liscense.getExpirationDate().getTime());
        }
        preparedStmt.setDate(3, expDate);

        preparedStmt.setInt(4, liscense.getPermitId());

        preparedStmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

}
