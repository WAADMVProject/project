/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.service;

import dmv.tobedeleteddao.appointmentDAO;
import dmv.tobedeleteddomain.ExamTimes;
import dmv.tobedeleteddomain.StartTime;
import dmv.tobedeleteddomain.accountEntity;
import dmv.tobedeleteddomain.addressEntity;
import dmv.tobedeleteddomain.appointmentEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SAMIPC
 */
public class appointmentService {

    private appointmentDAO appointmentDAO;
    private int accountId;

    private int ssn;
    appointmentEntity appointment = new appointmentEntity();

    public appointmentService() throws SQLException {
        try {
            appointmentDAO = new appointmentDAO();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    public appointmentEntity getPermit() {
        return appointment;
    }

    public void setAppointment(appointmentEntity appointment) {
        this.appointment = appointment;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void addAppointment() throws SQLException {
        appointment.setAccountId(accountId);
        appointmentDAO.addAppointment(appointment);
    }

    public ExamTimes getExamTimes(Date date) throws SQLException {
        ArrayList<Date> occupiedTimes = appointmentDAO.getOccupiedTimes(date);

        ExamTimes examTimes = new ExamTimes();
        //examTimes.getExamTimes().clear();
        for (int i = 0; i < occupiedTimes.size(); i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(occupiedTimes.get(i));
            examTimes.removeTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
            //examTimes.addTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
        }

        return examTimes;
    }

}
