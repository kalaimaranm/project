package in.web.application1;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class TimeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig sc) throws ServletException {
        System.out.println(">> init() method called");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().print("< align = \"center\"h1>" + "Your form submitted on :" + LocalDateTime.now() + "</h1>");
        response.getWriter().print(request.getSession().getAttribute("password") + ""
                + request.getSession().getAttribute("username"));
        Cookie ck =new Cookie("n ame", "kalaimaran");
        response.addCookie(ck);
    }

    @Override
    public String getServletInfo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroy() {
        System.out.println(">> destroy() method");
    }

}
