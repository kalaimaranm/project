package com.bassure.khatabook.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        
        try {
            DataSource ds = InitialContext.doLookup("");
            
            
        } catch (NamingException ex) {
            Logger.getLogger(ApplicationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
}
