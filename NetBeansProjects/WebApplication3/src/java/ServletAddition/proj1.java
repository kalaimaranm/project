package ServletAddition;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/addition")
public class proj1 extends HttpServlet {

    Scanner scan = new Scanner(System.in);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        int num1 = Integer.parseInt(request.getParameter("num1").trim());
        int num2 = Integer.parseInt(request.getParameter("num2").trim());
        int to = num1 + num2;
//        if(num1<0 || num2<0){
//            response.sendRedirect("proj2");
//        }
        int total = num1 + num2;
        pw.print("Total is " + total);
        pw.print("<h1>" + total + "</h1>");
        //s  pw.println("request redirect to proj2");
//        response.sendRedirect("servlet2?to="+to);
        String total2 = "7";
        Cookie cookie = new Cookie("pass", total2);
        response.addCookie(cookie);
        Cookie[] getCookie = request.getCookies();
        int value = 0;
        for (Cookie c : getCookie) {
            if (c.getName().equals("pass")) {
                value = Integer.parseInt(c.getValue());
            }
        }
        pw.println("<h2>" + "Cookies value is " + value + "</h2>");
        ServletContext context = request.getServletContext();
        String name1 = context.getInitParameter("username");
        pw.println("Hai " + name1);
        String password1 = context.getInitParameter("password");
        pw.println("<br>Your password is " + password1 + "<hr/>");
        ServletConfig config = getServletConfig();
        String name2 = config.getInitParameter("username");
        String password2 = config.getInitParameter("password");
        pw.println("<br>Servlet Config values are ");
        pw.println("<br>Hai " + name2);
        pw.println("<br>Your password is " + password2 + "<hr/>");
        Cookie message = new Cookie("message", "Thank You Visit Again.....!");
        response.addCookie(message);
        String thank = "";
        Cookie[] cook = request.getCookies();
        for (Cookie c : cook) {
            if (c.getName().equals("message")) {
                thank = c.getValue();
            }
        }
        pw.println("<h2>"+thank+"uh"+"</h2>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
