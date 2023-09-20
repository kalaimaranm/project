package TreeSetAlgorithm;

import java.util.Objects;
import java.time.LocalDate;

public class Customer implements Comparable {

    String name;
    int id;
    int age;
    LocalDate dateOfJoin;

    public Customer(String name, int id, int age, LocalDate date) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.dateOfJoin = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object t) {
        Customer c1 = (Customer) t;
        Customer c2 = (Customer) this;
        if (c2.getId() == c1.getId()) {
            return 0;
        } else if (c2.getId() > c1.getId()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", id=" + id + '}';
    }
}
