package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author bas200193
 */
public class ReflectionDemo {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Login user1 = new Login("Arun?890", "arunarun");
        System.out.println("class Name " + Login.class);
        Field[] field = Login.class.getDeclaredFields();
        Method[] method = user1.getClass().getDeclaredMethods();
        for (Method m : method) {
            if (m.getName().equals("testing")) {  // finding the testing method in method[]
                m.setAccessible(true);          // if method is private we accessing by passing true
                System.err.println(m.invoke(user1, "kalaimaran"));   // if method contains parameter then format eg:m.invoke(objectname,parameter)
            }
            if (m.getName().equals("protection")) {  // finding protection method in method[]
                m.setAccessible(true);
                System.out.println(m.invoke(user1));
            }
            if (m.getName().equals("staticMethod")) { // finding staticMethod method in method[]
                m.setAccessible(true);
                System.out.println(m.invoke(null));  // if method is static use null
            }
        }
//        for (int i = 0; i < field.length; i++) {
//            if (method[i].getName().equals("protection")) {
//                //method[i].setAccessible(true);
//                System.out.println(method[i].invoke(user1));
//
//            }
//        }
        //System.out.println(user1);
    }
}
