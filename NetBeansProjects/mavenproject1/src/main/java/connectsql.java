/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.sql.*;
public class connectsql 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
       String url="jdbc:mysql://bassure.in:3306/dineshmdb";
       String uname="dineshm";
       String pass="Abdevillers28";
       String query="select * from StudentDetails";
      //Class.forName("com.mysql.jdbc.driver");
        System.out.println("before connection");
      // Connection con = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/dineshmdb?user=dineshm&password=Abdevillers28");
      Connection con = DriverManager.getConnection(url,uname,pass);
       //Connection con=DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection ");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(query);
       String userdata="";
       while(rs.next())
       {
           userdata=rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3)+":"+rs.getString(4)+":"+rs.getString(5);
           System.out.println(userdata);
       }
       st.close();
       con.close();
    }
}