/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author bas200193
 */
public class FormatFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                //  log("FormatChecking:Initializing filter");
            }
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        PrintWriter out = response.getWriter();
        out.println("Before filter process");
        String reg = "";
        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
        if (request.getParameter("password").length() >= 8 && request.getParameter("password").length() <= 20) {
            // rd.forward(request, response);
            //res.sendRedirect("Welcome.jsp");
            chain.doFilter(request, response);
        } else {
            out.println("Given password is not in proper Format");
        }
        out.println("sdjklflakjsf");
    }

    public void destroy() {

    }

}
