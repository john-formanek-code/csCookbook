package enumus;

import java.util.EnumSet;

public class Enum {
     enum Day{
      MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
    public static void main(String[] args) {
        Day mDay =  Day.MONDAY;

        System.out.println("Value: " + mDay);

        for(Day d : Day.values()){
        System.out.println("--> " + d);
        }

        boolean a = mDay.equals(Day.FRIDAY);
        System.out.println(a);

        EnumSet<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        for(Day d : workDays){
            System.out.println("--> " + d);
            }

        switch (mDay) {
            case MONDAY:
                System.out.println("Je začátek praconího týdne!");
                break;
        
            default:
                break;
        }
    }
}
