package capriotti.anthony.TimeTranslator;

import java.util.regex.Pattern;

/**
 * Created by anthonycapriotti on 2/15/17.
 */
public class Converter {

    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty"};
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                            "eighteen", "nineteen"};

    protected static boolean validateTimeFormat(String input) {
        return Pattern.matches("((1[0-2]|0?[1-9]):([0-5][0-9]) ([AaPp][Mm]))", input);
    }

    protected static String[] parseTime(String input) {
        return input.split("[:\\s]");
    }

    protected static String convertHours(String hours) {
        return units[Integer.parseInt(hours)];
    }

    protected static String convertMinutes(String input) {
        int minutes = Integer.parseInt(input);
        if (minutes < 20) {
            input = units[minutes];
        } else {
            input = units[minutes % 10];
            minutes /= 10;
            input = tens[minutes % 10] + input;
        }
        return input ;
    }

    protected static String convertMeridiem(String input) {
        return (input.equalsIgnoreCase("pm") ? " pm" : " am");
    }

    public static String outputTime(String input) {
       String[] time = parseTime(input);
        if (validateTimeFormat(input)){
            return "The time is " + convertHours(time[0]) + convertMinutes(time[1]) + convertMeridiem(time[2]);
        } else
            return "incorrect time format";
    }

}

