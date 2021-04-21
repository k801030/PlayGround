package my.play.ground;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeApp {

    public static void main(String[] args) {
        DatetimeApp app = new DatetimeApp();
        String datetime = app.toISO8601(System.currentTimeMillis());
        System.out.println(datetime);
    }


    public String toISO8601(long timestamp) {
        // Input
        Date date = new Date(timestamp);

        // Conversion
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return sdf.format(date);

        // Output
        // "2017-02-16T21:00:00.000+01:00"
    }
}
