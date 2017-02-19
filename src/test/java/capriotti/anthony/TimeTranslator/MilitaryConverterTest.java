package capriotti.anthony.TimeTranslator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthonycapriotti on 2/17/17.
 */
public class MilitaryConverterTest {
    String time, time1, time2, time3, time4, time5;
    MilitaryConverter militaryConverter = new MilitaryConverter();

    @Before
    public void setup(){
        time = "23:00";
        time1 = "17:30";
        time2 = "09:42";
        time3 = "00:01";
        time4 = "24:78";
        time5 = "notvalidtime";
    }

    @Test
    public void validateMilitaryFormatTest(){
        boolean actual = militaryConverter.validateMilitaryFormat(time);
        assertTrue("true".equals(actual));
    }

    @Test
    public void validateMilitaryFormatTestInvalid(){
        boolean actual = militaryConverter.validateMilitaryFormat(time4);
        assertFalse("false".equals(actual));
    }

    @Test
    //hours two digits
    public void parseTimeHoursTest(){
        String expected = "23";
        String actual = militaryConverter.parseTime(time)[0];
        assertEquals("23 returns", expected, actual);
    }

    @Test
    public void parseTimeMinutesTest(){
        String expected = "00";
        String actual = militaryConverter.parseTime(time)[1];
        assertEquals("00 returns", expected, actual);
    }

    @Test
    public void convertHoursTest(){
        String expected = "nine";
        String actual = militaryConverter.convertHours(militaryConverter.parseTime(time2)[0]);
        assertEquals("oh nine returns", expected,actual);
    }

    @Test
    public void convertHoursTwentyPlusTest(){
        String expected = "twentyfour";
        String actual = militaryConverter.convertHours(militaryConverter.parseTime(time4)[0]);
        assertEquals("24 returns", expected, actual);
    }

    @Test
    public void convertMinutesTest(){
        String expected = "fortytwo";
        String actual = militaryConverter.convertMinutes(militaryConverter.parseTime(time2)[1]);
        assertEquals("thirty returns", expected,actual);
    }

    @Test
    //valid time output
    public void outputTest(){
        String expected = "The time is twentythreehundred";
        String actual = militaryConverter.outputMilitaryTime(time);
        assertEquals("output", expected, actual);
    }

    @Test
    //invalid time output
    public void invalidOutputTest(){
        String expected = "incorrect time format";
        String actual = militaryConverter.outputMilitaryTime(time5);
        assertEquals("Invalid time format", expected, actual);
    }
}
