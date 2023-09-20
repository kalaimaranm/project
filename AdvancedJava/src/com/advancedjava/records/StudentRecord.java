package com.advancedjava.records;

//      Records are immutable(final)
//      This is class are known as data class, model class, POJO class
//      Java 14 feature
//      To overcome Boiler plate code
//      It automatically default create canonical constructor, toString(), hashcode(), equals(), Getter(), But not Setter()-immutable by default
//      By default fields are private final 
//      Instance field is not allowed in record(all user declared fields must be static)
//      Record (class) should not extends other class because it implicitly extends Record class but we can implement interface
//      when to use record? when Your all the fields are private final go for record only getter no setter
//      Records support the compact constructor
public record StudentRecord(int id, String name) {

    public static String NAME_OF_SCHOOL;   // = "St.Joseph Matriculation School";
    
   
    // compact Constroctor
    public StudentRecord{
        if(name.isBlank()){
            throw new IllegalArgumentException("STUDENT NAME SHOULD NOT BE BLANK");
        }
    }

    public String timing(){
        return "Timing from 9.30AM to 4.30PM";
    }
    public void testing() {
        System.out.println("testing....");
    }
    
            
}

//    private String details;     - not allowed
//    private final String detail;
//   private  static String domain;
//    public StudentRecord(String name, int id) {
//        if (id == 0) {
//            throw new ArithmeticException();   IDE error
//        }
//    }
//public static final  int age;
//public StudentRecord(String name,int id,int age){
//    this.age = age;
//    this.name = name;
//    this.id = id;
//}
//static {
//    age = 0;
//}

