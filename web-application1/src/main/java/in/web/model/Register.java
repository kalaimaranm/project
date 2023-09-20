package in.web.model;

public class Register {

    private int id;
    private String name;
    private String role;

    public Register(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
