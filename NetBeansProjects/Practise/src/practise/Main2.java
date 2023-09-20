package practise;
//   singleton vs singletun
public class Main2 {

    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();
        System.out.println(single);
        System.out.println(single1);
        System.out.println(single2);
        System.out.println("Singletun class object creation using new Singletun");
        Singletun sing = Singletun.getInstance();
        Singletun sing1 = Singletun.getInstance();
        Singletun sing2 = Singletun.getInstance();
        System.out.println(sing);
        System.out.println(sing1);
        System.out.println(sing2);
    }
}

class Singleton {

    String s;
    static Singleton object;

    private Singleton() {
        s = "Hai I too bored>>>>>>>";
    }

    public static Singleton getInstance() {
        if (object == null) {
            object = new Singleton();
        }
        return object;
    }
}

class Singletun {

    String s;
    static Singletun object;

    private Singletun() {
        s = "Hai I too bored>>>>>>>>>>";
    }

    public static Singletun getInstance() {
        // if(object == null){
        //     object = new Sigletun();
        // }
        return new Singletun();
    }
}
