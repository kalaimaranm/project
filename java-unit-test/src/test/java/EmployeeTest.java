
import in.java.unit.test.Employee;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeTest {

    // class should have atleast one test method
    // use @Test and @Disable if you want to use @Disable because this method is still on running
    // instead of using Assertion we can make import static Assertions, It behave like those methdos are inside this class only, 
    //so you can access static method without class inside same class
    @Test
    public void testSalary() {
        Employee temp = new Employee();
        Assertions.assertEquals(0.0, temp.getSalary());  // assert -> fact
        Assertions.assertEquals(1.0, temp.getSalary());

    }

    @ParameterizedTest
    @ValueSource(ints = {10, 0, -10})
    public void idTest(int input) {
        Employee emp = new Employee();
        assertEquals(input, emp.getId());
    }

//    @ParameterizedTest
//    @ValueSource(ints = {22,65,90,24,26,17})   // grade3,grade0,grade0,grade2,grade0,Invalid
//    public void gradeTest(int age){
//        Employee emp = new Employee();
//        assert(emp.EmployeeGrade())
//    }
    @Test
    @BeforeAll
    public static void startUp() {
        System.out.println(" >> start up method()");
    }

    @Test
    @BeforeAll
    public static void startUp2() {
        System.out.println(" >> start up method() - 2");
    }
}
