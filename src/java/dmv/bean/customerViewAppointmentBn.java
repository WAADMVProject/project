/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.bean;

import dmv.model.AccountEntity;
import dmv.model.AppointmentEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author SAMIPC
 */
@Named("customerAppointmentsBn")
@SessionScoped
public class customerViewAppointmentBn implements Serializable {

    private AppointmentEntity appointment = new AppointmentEntity();
//    private appointmentService appointmentService;
    private Date date = new Date();
    private String chosenTime;
    private ArrayList<AppointmentEntity> appointments = new ArrayList();
    AccountEntity account = new AccountEntity();

    ArrayList<CustomDate> datetimes = new ArrayList();

    int count = 0;

    public class CustomDate {

        private String appointmentDate;
        private String time;

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    }

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AppointmentEntityFacade ejbAppointmentFacade;

    public customerViewAppointmentBn() throws SQLException {
//        appointmentService = new appointmentService();
        //        ArrayList<Date> sampleDates = new ArrayList();       
//        
//        Calendar c = Calendar.getInstance();
//        Date today = new Date();
//        c.setTime(date);
//        c

    }
   

    ArrayList<SelectItem> times = new ArrayList();

    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentEntity appointment) {
        this.appointment = appointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return chosenTime;
    }

    public void setTime(String time) {
        this.chosenTime = time;
    }

    public ArrayList<SelectItem> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<SelectItem> times) {
        this.times = times;
    }

    public ArrayList<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<CustomDate> getDatetimes() {
        return datetimes;
    }

    public void setDatetimes(ArrayList<CustomDate> datetimes) {
        this.datetimes = datetimes;
    }

    public void retrieveAppointments() {
        datetimes.clear();
        account.setId(Long.parseLong("0"));//to be changed
        appointments = ejbAppointmentFacade.getAppointments(account);
        Iterator it = appointments.iterator();
        while (it.hasNext()) {
            AppointmentEntity appointment = (AppointmentEntity) it.next();
            CustomDate customDate = new CustomDate();
            
            DecimalFormat formatter = new DecimalFormat("00");
            Calendar cal = Calendar.getInstance();
            cal.setTime(appointment.getDateTime());
            customDate.setAppointmentDate((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR)) ;
            customDate.setTime(formatter.format(cal.get(Calendar.HOUR))+":"+ formatter.format(cal.get(Calendar.MINUTE)));
            datetimes.add(customDate);            
        }
    }

}
