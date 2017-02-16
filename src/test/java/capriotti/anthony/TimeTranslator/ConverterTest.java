package capriotti.anthony.TimeTranslator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by anthonycapriotti on 2/16/17.
 */
public class ConverterTest {
    String time1, time2, time3;


    @Before
    public void setUp(){
        time1 = "09:30 pm";
        time2 = "12:30 am";
        time3 = "24:77 bm";
    }

    @Test
    public void validateTimeTest(){
        boolean actual = Converter.validateTimeFormat(time1);
        Assert.assertTrue("valid time format", actual);
    }

    @Test
    //invalid time format testing
    public void validateTimeTestFalse(){
        boolean actual = Converter.validateTimeFormat(time3);
        Assert.assertFalse("invalid time format", actual);
    }

    @Test
    public void parseHoursTest(){
        String expected = "09";
        String actual = Converter.parseTime(time1)[0];
        assertEquals("9 will return", expected, actual);
    }

    @Test
    public void parseMinutesTest(){
        String expected = "30";
        String actual = Converter.parseTime(time1)[1];
        assertEquals("30 will return", expected, actual);
    }

    @Test
    public void parseMeridiemTest(){
        String expected = "am";
        String actual = Converter.parseTime(time2)[2];
        assertEquals("ante merīdiem will output", expected, actual);
    }

    @Test
    public void convertHoursTest(){
        String expected = "nine";
        String actaul = Converter.convertHours(Converter.parseTime(time1)[0]);
        assertEquals("nine", expected, actaul);
    }

    @Test
    public void convertMinutesTest(){
        String expected = "thirty";
        String actual = Converter.convertMinutes(Converter.parseTime(time1)[1]);
        assertEquals("thirty will return", expected, actual);
    }



}
