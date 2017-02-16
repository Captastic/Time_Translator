package capriotti.anthony.TimeTranslator;

/**
 * Created by anthonycapriotti on 2/15/17.
 */
public class Time {

    public String[] units = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "noon",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public String[] tens = {"twenty", "thirty", "forty", "fifty"};

    public Time(String[] units, String[] tens) {
        this.units = units;
        this.tens = tens;
    }
}

