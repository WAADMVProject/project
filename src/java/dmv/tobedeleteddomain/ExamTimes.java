/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.tobedeleteddomain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author SAMIPC
 */
public class ExamTimes {

    private ArrayList<StartTime> examTimes = new ArrayList();

    public ExamTimes() {
        examTimes.add(new StartTime(8, 30));
        examTimes.add(new StartTime(9, 00));
        examTimes.add(new StartTime(9, 30));
        examTimes.add(new StartTime(10, 00));
        examTimes.add(new StartTime(10, 30));
        examTimes.add(new StartTime(11, 00));
        examTimes.add(new StartTime(11, 30));
        examTimes.add(new StartTime(1, 00));
        examTimes.add(new StartTime(1, 30));
        examTimes.add(new StartTime(2, 00));
        examTimes.add(new StartTime(2, 30));
        examTimes.add(new StartTime(3, 00));
        examTimes.add(new StartTime(3, 30));
        examTimes.add(new StartTime(4, 00));
    }

    public ArrayList<StartTime> getExamTimes() {
        return examTimes;
    }

    public void setExamTimes(ArrayList<StartTime> examExamTimes) {
        this.examTimes = examExamTimes;
    }

    public void addTime(int hour, int minute) {
        StartTime startTime = new StartTime(hour, minute);
        examTimes.add(startTime);
    }

    public void removeTime(int hour, int minute) {

        Iterator<StartTime> it = examTimes.iterator();
        while (it.hasNext()) {
            StartTime time = it.next();
            if (time.getHour() == hour && time.getMinute() == minute) {
                it.remove();
            }
        }

    }

}
