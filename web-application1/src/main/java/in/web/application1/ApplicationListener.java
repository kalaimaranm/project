package in.web.application1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ApplicationListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        try {
            DataSource ds = (DataSource) InitialContext.doLookup("java:comp/env/jdbc/myDB");
            context.setAttribute("dbpool", ds);
//        InitialContext context = InitialContext 
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext();
        ServletContext context = sce.getServletContext();
        try {
            DataSource ds = (DataSource) InitialContext.doLookup("java.comp/env/jdbc/myDB");
//      context.setAttribute("dbpool", ds);
            context.removeAttribute("dbpool");
//        InitialContext context = InitialContext 
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
    }
}
