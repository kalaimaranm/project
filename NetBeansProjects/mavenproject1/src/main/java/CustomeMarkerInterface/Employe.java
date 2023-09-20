package CustomeMarkerInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bas200193
 */
public class Employe implements Validation {

    Employe() throws EmployeValidationException {

    }

    {
        InterfaceLogic.check(this);

    }
//    {
//        try {
//            InterfaceLogic.check(this);
//        } catch (EmployeValidationException ex) {
//           // Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
