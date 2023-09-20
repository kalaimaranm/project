/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reflection;

public class Login {

    private String userName;
    private String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "userName=" + userName + ", password=" + password + '}';
    }

    public String getUserName() {
        return userName;
    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
    public String getPassword() {
        return password;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
    private String credential() {
        return "userName: " + this.userName + "\npassword: " + this.password;
    }

    private String protection() {
        return "This method is protected with private";
    }

    private String testing(String name) {
        return "Testing completed " + name;
    }

    private static String staticMethod() {
        return "This is static method";
    }
}
