
package DateDemo;
import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate addDate = date.plusDays(10);
        System.out.println(date);
        LocalDate minusDate = date.minusDays(10);
        System.out.println(minusDate);
        LocalDate.parse();
    }
}
