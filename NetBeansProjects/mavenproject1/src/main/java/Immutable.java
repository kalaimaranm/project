/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Immutable {
    String name;
    Immutable(String name){
        this.name = name;
    }
    public static void main(String[] args) {
        Immutable i = new Immutable("rajesh");
        Immutable i2 = i.modify(i2);
    }
    public Immutable modify(Object o){
        String oname = (String) o.name;
        if(this.name==(String)o.name){
        return this;
}
        else{
            return new Immutable();
        }
    }
}
