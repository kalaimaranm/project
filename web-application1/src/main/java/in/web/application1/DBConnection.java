package in.web.application1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DBConnection extends HttpServlet {
    
    static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    static String user = "Kalai";
    static String pass = "Kalai@4321";
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        DataSource ds = (DataSource) context.getAttribute("dbpool");
        try {
            PrintWriter out = response.getWriter();
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from authentication_and_authorization");
            while (result.next()) {
                out.println("UserId : " + result.getInt(1) + "\npassword :" + result.getString(2) + "\nrole :" + result.getString(3));
            }
//       Connection context = (Connection) request.getServletContext().getAttribute("dbpool");
//        try (Connection connection = DriverManager.getConnection(url, user, pass);
//            PreparedStatement statement = connection.prepareStatement("insert into form (name,mail,address,phoneno) values (?,?,?,?)")) {
//             statement.setInt(1,1);
//            statement.setString(1, register.getName());
//            statement.setString(2, register.getMail());
//            statement.setString(3, register.getAddress());
//            statement.setString(4, register.getPhoneNo());
//            int result = statement.executeUpdate();
//            return  result != 0;
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public boolean dataInsertion(Register register) throws SQLException, IOException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
//        Connection con = 
//        try (Connection connection = DriverManager.getConnection(url, user, pass);
//            PreparedStatement statement = connection.prepareStatement("insert into form (name,mail,address,phoneno) values (?,?,?,?)")) {
////             statement.setInt(1,1);
//            statement.setString(1, register.getName());
//            statement.setString(2, register.getMail());
//            statement.setString(3, register.getAddress());
//            statement.setString(4, register.getPhoneNo());
//            int result = statement.executeUpdate();
//            return  result != 0;
//
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        return false;
//    }
}
