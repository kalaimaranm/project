package in.java.unit.test;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee() {

    }

    public String EmployeeGrade(int age) {
        if (age >= 18) {
            if (age <= 22) {
                return "GRADE-3";
            } else if (age <= 24) {
                return "GRADE-2";
            } else if (age <= 25) {
                return "GRADE-1";
            } else {
                return "GRADE-0";
            }
        } else {
            return "Invalid age";
        }
    }

    static {
        Employee emp1 = new Employee(1001, "Natraj", 100000.0, 22);
        Employee emp2 = new Employee(1002, "Jobin", 100000.0, 24);
        Employee emp3 = new Employee(1003, "Naveen", 100000.0, 25);
        Employee emp4 = new Employee(1004, "Kalaimaran", 100000.0, 22);
        Employee emp5 = new Employee(1005, "Dinesh", 100000.0, 23);
        Employee emp6 = new Employee(1005, "DineshDup", 100000.0, 26);
    }

}
