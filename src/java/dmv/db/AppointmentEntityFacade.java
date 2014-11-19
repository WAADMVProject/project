/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.db;

import dmv.model.AccountEntity;
import dmv.model.AppointmentEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SAMIPC
 */
@Stateless
public class AppointmentEntityFacade extends AbstractFacade<AppointmentEntity> {

    @PersistenceContext(unitName = "WAADMVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppointmentEntityFacade() {
        super(AppointmentEntity.class);
    }

    public ArrayList<Date> getOccupiedTimes(Date date) {
        ArrayList<Date> times = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
// String query = "select dateTime from appointment where " +
//                "YEAR(dateTime) = "+ cal.get(Calendar.YEAR)
//                + " AND MONTH(dateTime) = " + (cal.get(Calendar.MONTH)+1)
//                + " AND  DAY(dateTime) = " + cal.get(Calendar.DAY_OF_MONTH);

        List results = em.createQuery(
                "SELECT a.dateTime FROM AppointmentEntity a WHERE "
                + "FUNCTION('YEAR',a.dateTime) = " + cal.get(Calendar.YEAR)
                + " AND FUNCTION('MONTH',a.dateTime) = " + (cal.get(Calendar.MONTH)+1)
                + " AND FUNCTION('DAY',a.dateTime) = " + cal.get(Calendar.DAY_OF_MONTH)).getResultList();

        Iterator it = results.iterator();
        while (it.hasNext()) {
            times.add((Date) it.next());
        }

        return times;
    }
    
    public ArrayList<AppointmentEntity> getAppointments(AccountEntity account) {
        ArrayList<AppointmentEntity> appointments = new ArrayList();
         List results = em.createQuery(
                "SELECT ap FROM AppointmentEntity ap WHERE ap.accountId = "+account.getId()).getResultList();
         Iterator it = results.iterator();
         while(it.hasNext()){
             appointments.add((AppointmentEntity) it.next());
         }
         
         return appointments;
    }
    
     public ArrayList<AppointmentEntity> getAllAppointments() {
        ArrayList<AppointmentEntity> appointments = new ArrayList();
         List results = em.createQuery(
                "SELECT ap FROM AppointmentEntity ap").getResultList();
         Iterator it = results.iterator();
         while(it.hasNext()){
             appointments.add((AppointmentEntity) it.next());
         }
         
         return appointments;
    }

}
