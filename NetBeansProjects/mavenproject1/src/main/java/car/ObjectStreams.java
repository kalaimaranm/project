package car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author bas200193
 */
public class ObjectStreams implements Serializable {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Car c = new Car("TATA", 1000000.00, "Black", new Engine("TATA", "Harrier", 1000000.00));
        try ( FileOutputStream fos = new FileOutputStream("/home/bas200193/Desktop/textFiles/Objects/object.txt");  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(c);
            FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Objects/object.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (ois.readObject() instanceof Car c1) {
                System.out.println("File readed Successfully");
                System.out.println(c1);

            }
        }
        Car c3 = new Car("Mahindra", 2500000.00, "Black", new Engine("Mahindra", "Scorpio", 2500000.00));
//      Thread t = new Thread();
//        System.out.println(t instanceof Thread);
//        System.out.println(t instanceof Runnable);
//        System.out.println(t instanceof Object);
//       // System.out.println(t instanceof String);
System.out.println(c3);
      
    }
}
