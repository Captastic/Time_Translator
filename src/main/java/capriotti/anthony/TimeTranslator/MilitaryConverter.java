package capriotti.anthony.TimeTranslator;

import java.util.regex.Pattern;

/**
 * Created by anthonycapriotti on 2/17/17.
 */

//

public class MilitaryConverter {

    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty"};
    private static final String[] units = {"hundred", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                             "eighteen", "nineteen"};


    protected static boolean validateMilitaryFormat(String input){
        return Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", input);
    }

    protected static String[] parseTime(String input){
        return input.split("[:\\s]");
    }

    protected static String convertHours(String input){
        int hours = Integer.parseInt(input);
        if (hours < 20) {
            input =  units[hours];
        } else if (hours >= 20)
            input = units[hours % 10];
            hours /= 10;
            input = tens[hours % 10] + input;
            return input;
    }

    protected static String convertMinutes(String input){
        int minutes = Integer.parseInt(input);
        if (minutes < 20)
            input = units[minutes];
        else if (minutes >= 20)
            input = units[minutes % 10];
            minutes /= 10;
            input = tens[minutes % 10] + input;
            return input;
    }

    protected static String outputMilitaryTime(String input){
        String[] time = parseTime(input);
        if (validateMilitaryFormat(input)){
            return "The time is " + convertHours(time[0]) + convertMinutes(time[1]);
        } else
            return "incorrect time format";    }


}
