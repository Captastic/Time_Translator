package capriotti.anthony.TimeTranslator;

/**
 * Created by anthonycapriotti on 2/15/17.
 */
public class Converter {

    private static final String[] tens = {"ten", "twenty", "thirty", "forty", "fifty"};
    private static final String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                            "eighteen", "nineteen"};

    protected static boolean validateTimeFormat(String input){
        String[] time = input.split("\\b((1[0-2]|0?[1-9]):([0-5][0-9])([AaPp][Mm]))");
        return time.equals(time);
    }

    protected static String[] parseTime (String input) {
        return input.split("[:\\s]+");
    }

    protected static String convertHours (String input){
        return units[Integer.parseInt(input)];
    }

    protected static String convertMinutes (String input){
        return null;
    }

    protected static String convertMeridiem (String input){
        return null;
    }

    protected static String outputTime (String input){
        return null;
    }


}
