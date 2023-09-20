package in.web.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//@WebFilter(filterName = "Filter2", urlPatterns = {"/*"})
public class Filter2 implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(">> Inside Filter2 chaining\n LocalDate and Time:" + LocalDateTime.now());
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
        
    }
    
}
