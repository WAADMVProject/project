/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddao;

import dmv.tobedeleteddomain.permitEntity;
import dmv.tobedeleteddomain.permitEntity;
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
public class permitDAO {

    Statement stmt = null;
    DBConnection dbc;
    Connection con;

    public permitDAO() throws IOException {
        dbc = new DBConnection();
        con = dbc.getLocalConnection();
    }

    public void addPermit(permitEntity permit) throws SQLException {

        stmt = con.createStatement();

        String query = "insert into permit (picture,ssnIsVerified,visionScore,writtenTestSCore,signature,drivingLiscenseNumber,issuanceDate,expirationDate,accountId) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, permit.getPicture());
        preparedStmt.setBoolean(2, permit.isSsnIsVerified());
        preparedStmt.setInt(3, permit.getVisionScore());
        preparedStmt.setInt(4, permit.getWrittenTestScore());
        preparedStmt.setString(5, permit.getSignature());
        preparedStmt.setString(6,permit.getDrivingLiscenseNumber());
       
        
        java.sql.Date issueDate = null;
        if(permit.getIssuanceDate() != null)
            issueDate = new java.sql.Date(permit.getIssuanceDate().getTime());
        preparedStmt.setDate(7, issueDate);
        java.sql.Date expDate = null;
        if(permit.getExpirationDate() != null)
            expDate = new java.sql.Date(permit.getExpirationDate().getTime());
        preparedStmt.setDate(8, expDate);
         preparedStmt.setInt(9, permit.getAccountId());
       

        preparedStmt.executeUpdate();
    }
    
    public int getPermitId(int dln) throws SQLException {
        ArrayList<Integer> ids = new ArrayList();
        stmt = con.createStatement();
        String query = "select id from permit where drivingLiscenseNumber = "+ dln;
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
