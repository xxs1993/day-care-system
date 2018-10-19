package csye6200.util;

import com.google.common.base.Strings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String DATE_FORMAT = "MM/dd/yyyy";


    /**
     * transfer localdate to string
     *
     * @param date
     * @return
     */
    public static String dateToString(LocalDate date){
        if(date == null){
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return  date.format(dateTimeFormatter);
    }


    /**
     * transfer date to string
     *
     * @param s
     * @return
     */
    public static LocalDate stringToDate(String s){
        if(Strings.isNullOrEmpty(s)){
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate localDate =  LocalDate.parse(s,dateTimeFormatter);
        return localDate;
    }
}
