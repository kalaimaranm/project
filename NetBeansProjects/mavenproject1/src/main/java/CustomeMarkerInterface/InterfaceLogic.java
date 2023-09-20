package CustomeMarkerInterface;

/**
 *
 * @author bas200193
 */
public class InterfaceLogic {

    public static boolean check(Object object) throws EmployeValidationException {
        if (object instanceof Validation) {
            return true;
        } else {
            throw new EmployeValidationException("EmployeValidationExcaption");
        }

    }
}
