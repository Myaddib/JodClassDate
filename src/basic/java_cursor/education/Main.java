package basic.java_cursor.education;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        // write your code here
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        System.out.println(bartDateFormat.format(date));

        Calendar validity = new GregorianCalendar();
        Date dateOfManufactureTEMP = validity.getTime();
        validity.add(Calendar.DAY_OF_YEAR, 1);
        Date validityTemp = validity.getTime();

        Date c = new Date();
        Date b = new Date();

        System.out.println(bartDateFormat.format(c));
        System.out.println(bartDateFormat.format(dateOfManufactureTEMP));
        System.out.println(bartDateFormat.format(validityTemp));


        int z = calculateDifference(c, validityTemp);

        if (z <= 15) {
            System.out.println(4 * 0.7);
        } else {
            System.out.println(4);
        }
    }

    public static int calculateDifference(Date a, Date b) {
        int tempDifference = 0;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (a.compareTo(b) < 0) {
            earlier.setTime(a);
            later.setTime(b);
        } else {
            earlier.setTime(b);
            later.setTime(a);
        }

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        return difference;
    }


}



