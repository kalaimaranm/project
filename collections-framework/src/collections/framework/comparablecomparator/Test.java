package collections.framework.comparablecomparator;

public class Test {

    public static void main(String[] args) {

        Test.printInfo(new Doctor());

    }

    interface Human {

    }

    static class Doctor implements Human {

    }

    class Animal {

    }

    class Dog extends Animal {

    }

    public static <T extends Human> void printInfo(T data) {

        System.out.println("printInfo ");
    }

}
