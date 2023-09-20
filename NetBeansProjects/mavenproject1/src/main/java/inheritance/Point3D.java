/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Point3D {
   private float z;
    Point3D(float x,float y,float z){
       this.z = z;
   }
    Point3D(){
       
   }
   public float getZ(){
       return this.z;
   }
   public void setZ(float z){
       this.z = z;
   }
   public void setXYZ(float x,float y, float z){
       // dummy 
   }
   public float[] getXYZ(){
       int xx,yy,zz;
       xx= x;
       yy = y;
       zz = z;
       float[] f = new float[3];
       f[0] = x;
       
       return 
   }
}
