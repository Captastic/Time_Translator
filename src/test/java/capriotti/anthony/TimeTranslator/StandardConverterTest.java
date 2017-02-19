package capriotti.anthony.TimeTranslator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by anthonycapriotti on 2/16/17.
 */
public class StandardConverterTest {
    String time1, time2, time3, time4, time5, time6, time7;


    @Before
    public void setUp(){
        time1 = "09:30 pm";
        time2 = "12:30 am";
        time3 = "wrongtime bm";
        time4 = "08:00 am";
        time5 = "23:60 pm";
        time6 = "05:06 pm";
        time7 = "07:45 pm";
    }

    @Test
    //valid format testing
    public void validateTimeTest(){
        boolean actual = StandardConverter.validateTimeFormat(time1);
        Assert.assertTrue("valid time format".equals(actual));
    }

    @Test
    //invalid time format testing
    public void validateTimeTestFalse(){
        boolean actual = StandardConverter.validateTimeFormat(time3);
        Assert.assertFalse("invalid time format".equals(actual));
    }

    @Test
    //non-military time >12 >59 test
    public void validateTimeTestIncorrectValues(){
        boolean actual = StandardConverter.validateTimeFormat(time5);
        Assert.assertFalse("invalid time format".equals(actual));
    }

    @Test
    //1#:## test
    public void parseHoursOneDigitTest(){
        String expected = "09";
        String actual = StandardConverter.parseTime(time1)[0];
        assertEquals("9 will return", expected, actual);
    }

    @Test
    //11:## test
    public void parseHoursTwoDigitsTest(){
        String expected = "12";
        String actual = StandardConverter.parseTime(time2)[0];
        assertEquals("12 will return", expected, actual);
    }

    @Test
    //##:0# test
    public void parseMinutesOneDigitsTest(){
        String expected = "06";
        String actual = StandardConverter.parseTime(time6)[1];
        assertEquals("06 will return", expected, actual);
    }

    @Test
    //##:30 test
    public void parseMinutesTwoDigitsTest(){
        String expected = "30";
        String actual = StandardConverter.parseTime(time1)[1];
        assertEquals("30 will return", expected, actual);
    }

    @Test
    public void parseMeridiemTest(){
        String expected = "am";
        String actual = StandardConverter.parseTime(time2)[2];
        assertEquals("ante merīdiem will output", expected, actual);
    }

    @Test
    public void convertHoursTest(){
        String expected = "nine";
        String actaul = StandardConverter.convertHours(StandardConverter.parseTime(time1)[0]);
        assertEquals("nine", expected, actaul);
    }

    @Test
    //testing 00 minute value
    public void convertMinutes00Test(){
        String expected = "";
        String actual = StandardConverter.convertMinutes(StandardConverter.parseTime(time4)[1]);
        assertEquals("00 returns ", expected, actual);
    }

    @Test
    //testing 0# minute value
    public void convertMinutes01Test(){
        String expected = "six";
        String actual = StandardConverter.convertMinutes(StandardConverter.parseTime(time6)[1]);
        assertEquals("six will return", expected, actual);
    }

    @Test
    public void convertMinutesTwoDigitsTest(){
        String expected = "thirty";
        String actual = StandardConverter.convertMinutes(StandardConverter.parseTime(time1)[1]);
        assertEquals("thirty will return", expected, actual);
    }

    @Test
    public void convertMinutesTest(){
        String expected = "fortyfive";
        String actual = StandardConverter.convertMinutes(StandardConverter.parseTime(time7)[1]);
        assertEquals("forty-five will return", expected, actual);
    }

    @Test
    //am test
    public void convertMeridiemAMTest(){
        String expected = " am";
        String actual = StandardConverter.convertMeridiem(StandardConverter.parseTime(time2)[2]);
        assertEquals("am will return", expected, actual);
    }

    @Test
    //pm test
    public void convertMeridiemPMTest(){
        String expected = " pm";
        String actual = StandardConverter.convertMeridiem(StandardConverter.parseTime(time1)[2]);
        assertEquals("pm will retunr", expected, actual);
    }

    @Test
    //output time
    public void outputTimeTest(){
        String expected = "The time is ninethirty pm";
        String actual = StandardConverter.outputTime(time1);
        assertEquals("the time is...", expected,actual);
    }

    @Test
    //invalid output format
    public void outputTimeInvalidFormatTest(){
        String expected = "incorrect time format";
        String actual = StandardConverter.outputTime(time3);
        assertEquals("invalid time format", expected, actual);
    }





}
