import org.example.DateUtils;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DateUtilsTest {
    public ArrayList<DateUtils> date;

    @BeforeAll
    public void InitClass(){
        date= new ArrayList<>();
    }

    @BeforeEach
    public void initMethod(){
        DateUtils date1 = new DateUtils();
        date.add(date1);
    }

    @Test
    public void testIsLapYearValid(){
    DateUtils dateTest = date.getFirst();
        Assertions.assertTrue(dateTest.isLeapYear(2000));
    }


    @Test
    public void testIsLapYearInValid(){
        DateUtils dateTest = date.getFirst();
        Assertions.assertFalse(dateTest.isLeapYear(2001));
    }

    @Test
    public void testGetDaysInMonthInThisYear(){
        DateUtils dateTest = date.getFirst();
        Assertions.assertEquals(31,dateTest.getDaysInMonth(2024, 3));
    }

    @Test
    public void testGetDaysInMonth2LapYear(){
        DateUtils dateTest = date.getFirst();
        Assertions.assertEquals(29,dateTest.getDaysInMonth(2024, 2));
    }

    @Test
    public void testGetDaysInMonth2NotLapYear(){
        DateUtils dateTest = date.getFirst();
        Assertions.assertEquals(28,dateTest.getDaysInMonth(2023, 2));
    }

    @AfterEach
    public void cleanMethod(){
       date.clear();
    }


    @AfterAll
    public void cleanClass(){
        date.clear();
    }

}
