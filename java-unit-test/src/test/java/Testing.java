
import in.java.unit.test.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Testing {

    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(4, calculator.add(2, 2));
        //     asserNotEquals(,);
    }
}
