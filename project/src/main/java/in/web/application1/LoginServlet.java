package in.web.application1;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.print("""
                  <html>
                  <head>
                  <title></title></head>
                  <body>
                  <div align = "center">
                  <h1>Welcome Enter Your Credential</h1>
                  <form action = "j_security_check" method = "post">
                  username   <input type ="text" name = "j_username" /><br/>
                  password   <input type = "password" name = "j_password" /><br/>
                  <input type = "submit" value = "login"></form>
                  <div>
                  </body>
                  </html>""");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        HttpSession session = request.getSession();
//        session.setAttribute("username", "arun");
//        session.setAttribute("password", "arun@123");

//        request.setAttribute(username, this);
//        request.getAttribute(username);
//        if (username.equals("arun") && password.equals("arun@123")) {
//            response.sendRedirect("time");
//        }
    }

}
