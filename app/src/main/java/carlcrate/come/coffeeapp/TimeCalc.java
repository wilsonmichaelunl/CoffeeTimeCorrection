package carlcrate.come.coffeeapp;

/**
 * Created by michael on 12/18/17.
 */

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeCalc {
    String getTime(String endTime, String timeOnMaker) throws ParseException, InvocationTargetException {
        //These next three lines take in the current time
       try {
           DateFormat df = new SimpleDateFormat("HH:mm");
           Date dateobj = new Date();
           String timeNow = (df.format(dateobj));

           SimpleDateFormat format = new SimpleDateFormat("HH:mm");
           Date date1 = format.parse(timeNow);
           Date date2 = format.parse(endTime);

           if (date1.getTime() > date2.getTime()) {
               Calendar c = Calendar.getInstance();
               c.setTime(date2);
               c.add(Calendar.DATE, 1);
               date2 = c.getTime();
           }

           long differenceInSeconds = (date2.getTime() - date1.getTime()) / 1000;
           long differenceInMinutes = differenceInSeconds / 60;
           long differenceInHours = differenceInMinutes / 60;
           long leftoverMinutes = differenceInMinutes % 60;

           int minutesAhead = (int) (differenceInMinutes * 1.2);
           differenceInHours = minutesAhead / 60;
           leftoverMinutes = minutesAhead % 60;

           Date date3 = format.parse(timeOnMaker);

           Calendar cal = Calendar.getInstance();
           cal.setTime(date3);
           cal.add(Calendar.MINUTE, minutesAhead);
           String newTime = format.format(cal.getTime());

           return "Set your coffee maker to make coffee at " + newTime;
       } catch (ParseException e){
           return "Your input was invalid. Please try again.";
       }
    }
}
