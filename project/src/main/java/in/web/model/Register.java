package in.web.model;

public class Register {

    private String name;
    private String gender;
    private String mail;
    private String address;
    private String phoneNo;
    private String[] Hobbies;

    public Register(String name, String gender, String mail, String address, String phoneNo, String[] Hobbies) {
        this.name = name;
        this.gender = gender;
        this.mail = mail;
        this.address = address;
        this.phoneNo = phoneNo;
        this.Hobbies = Hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String[] getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String[] Hobbies) {
        this.Hobbies = Hobbies;
    }

}
