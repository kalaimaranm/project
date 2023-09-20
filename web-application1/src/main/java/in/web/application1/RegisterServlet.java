package in.web.application1;

import in.web.dao.CustomerDAO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import in.web.model.Register;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("inside service()");
//        Register register = new Register(request.getParameter("name"),
//                request.getParameter("gender"),
//                request.getParameter("mail"),
//                request.getParameter("address"),
//                request.getParameter("phoneno"),
//                request.getParameterValues("hobbies"));
//        try {
            CustomerDAO insertData = new CustomerDAO();
//            if (insertData.dataInsertion(register)) {
//                response.getWriter().print("before forward\n");
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("time");
//                requestDispatcher.include(request, response);
////                if (response.isCommitted()) {
////                    requestDispatcher.forward(request, response);
////                }                                                          doubt
//                response.getWriter().print("\nafter forward");
//            } else {
//                response.getWriter().print("submition failed...");
//            }

//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
