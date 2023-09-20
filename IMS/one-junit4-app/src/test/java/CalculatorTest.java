import com.kalai.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

@Test
    public void testAdd() {
        Calculator calculator = new Calculator();
       Integer actualResult = calculator.add(10, 10);
       Integer expectedResult = 200;
       assertEquals(expectedResult, actualResult);
    }

//    @Parameterized
    public void testIsPalindrome(String str) {


    }
}
