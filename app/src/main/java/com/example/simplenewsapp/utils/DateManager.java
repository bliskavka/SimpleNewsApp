package com.example.simplenewsapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {

    public static String getDateFromMillis(long timestamp){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, hh:mm");
        String dateString = formatter.format(new Date(timestamp));
        return dateString;
    }

    public static long parseToMillis(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try
        {
            Date mDate = sdf.parse(date);
            long timeInMilliseconds = mDate.getTime();
            return timeInMilliseconds;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return 0;
    }
}
