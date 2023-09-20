/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khatabook;

/**
 *
 * @author bas200193
 */
public class PhoneNumberFormatException extends Exception{

    public PhoneNumberFormatException() {
        super();
    }
    public PhoneNumberFormatException(String s){
        super(s);
    }
    public PhoneNumberFormatException(Throwable th){
        super(th);
    }
    public PhoneNumberFormatException(String s,Throwable th){
        super(s,th);
    }
    
}
