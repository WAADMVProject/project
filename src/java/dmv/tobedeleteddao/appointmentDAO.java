/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddao;

import dmv.tobedeleteddomain.appointmentEntity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.DBConnection;

/**
 *
 * @author SAMIPC
 */
public class appointmentDAO {

    Statement stmt = null;
    DBConnection dbc;
    Connection con;

    public appointmentDAO() throws IOException {
        dbc = new DBConnection();
        con = dbc.getLocalConnection();
    }

    public void addAppointment(appointmentEntity appointment) throws SQLException {

        stmt = con.createStatement();

        String query = "insert into appointment (dateTime) values (?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);

        java.sql.Timestamp dateTime = null;
        if (appointment.getDateTime() != null) {
            dateTime = new java.sql.Timestamp(appointment.getDateTime().getTime());
        }

        preparedStmt.setTimestamp(1, dateTime);
        preparedStmt.executeUpdate();
    }

    public ArrayList<Date> getOccupiedTimes(Date date) throws SQLException {
        ArrayList<Date> times = new ArrayList();
         Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        stmt = con.createStatement();
        String query = "select dateTime from appointment where " +
                "YEAR(dateTime) = "+ cal.get(Calendar.YEAR)
                + " AND MONTH(dateTime) = " + (cal.get(Calendar.MONTH)+1)
                + " AND  DAY(dateTime) = " + cal.get(Calendar.DAY_OF_MONTH);
        
       
//        PreparedStatement preparedStmt = con.prepareStatement(query);
//        preparedStmt.setInt(1, );
//        preparedStmt.setInt(2, );
//        preparedStmt.setInt(3, );

                
        ResultSet rs =  stmt.executeQuery(query);   //preparedStmt.executeQuery(query);
        while (rs.next()) {
            times.add(rs.getTimestamp(1));
        }
        return times;
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

}
