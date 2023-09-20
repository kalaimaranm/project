package in.web.application1;

import in.web.dao.CustomerClass;
import in.web.dao.CustomerDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewProfileServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        out.print("Weclome Your profile viewed.... :)");

        List<CustomerClass> customers = new ArrayList<>();
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            
            request.getSession().setAttribute("customerList", customerDAO.getAllCustomer());
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewPage.jsp");
          //  this.getServletContext().getRequestDispatcher();
            dispatcher.forward(request, response);
//            response.sendRedirect("/viewPage.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(ViewProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
