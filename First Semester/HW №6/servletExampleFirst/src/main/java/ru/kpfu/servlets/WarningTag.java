package ru.kpfu.servlets;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class WarningTag extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        JspWriter writer = getJspContext().getOut();
        writer.println("Warning!This page may be dangerous for you!");

    }
}
