/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */

  // import  javasql.first;
import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("This is java data base connectivity");
		//try {
			String query = "select * from actor limit 6";
			String url="jdbc:mysql://bassure.in:3306/kalaimarandb";
			String uname = "Kalai";
			String pass = "Kalai@4321";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);//("jdbc:mysql://bassure.in:3306/sakila?user=Kalai&password=Kalai@4321");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("actor_id");
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			System.out.print(id);
System.out.print(" "+firstName);
System.out.println(" "+ lastName);
			}
st.close();
con.close();
//PDDocument pd = new PDDocument();
//pd.save();
			
		//} 
                //catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	System.out.println(e);
		//}

	}

}

		//	Connection con = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/sakila?user=dinesh&password=dinesh@4321");



    

