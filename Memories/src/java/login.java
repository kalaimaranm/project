
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dis = request.getRequestDispatcher("Error.jsp");
        RequestDispatcher dis2 = request.getRequestDispatcher("Welcome.jsp");
        try {
            String userId = request.getParameter("userId").trim();
            String password = request.getParameter("password").trim();
            //int s = Integer.parseInt("kj");  //Error Check
            if (userId.equalsIgnoreCase("Thangam@gmail.com") && password.equals("ThangamThangam")) {
                HttpSession session = request.getSession();
                session.setAttribute("userIds", userId);
               // response.sendRedirect("Welcome.jsp");
               dis2.forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("userId or password is incorrect");
            }
        } catch (Exception e) {
            dis.forward(request, response);
        }
    }

}
