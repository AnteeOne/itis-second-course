package ru.kpfu.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class EdgeFilter implements Filter {

    private FilterConfig filterConfig = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("User Agent == " + httpServletRequest.getHeader("User-Agent"));
        Pattern pattern = Pattern.compile(".+Edge.+");
        if(!pattern.matcher(httpServletRequest.getHeader("User-Agent")).matches()){

            filterChain.doFilter(servletRequest, servletResponse);

        }
        else{
            //TODO: create logic for non-edge browser
            PrintWriter printWriter = servletResponse.getWriter();
            printWriter.println("Sorry,your browser doesn't support this page :(");
            printWriter.flush();
            printWriter.close();

        }


    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
