package ru.kpfu.servlets;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class FormTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter writer = getJspContext().getOut();
        writer.println(getButtonCode);
    }

    public String getButtonCode = "<button type=\"submit\" class=\"register_button\">Register</button>\n" +
            " <style>.register_button {\n" +
            "  width: 149px;\n" +
            "  height: 42px;\n" +
            "  background-color: #ffa500;\n" +
            "  border-radius: 10px;\n" +
            "  margin:30px;\n" +
            "  text-align: center;\n" +
            "  cursor: pointer;\n" +
            "  clear: both;\n" +
            "}\n" +
            ".register_button:hover {\n" +
            "  background-color: white;\n" +
            "  color: #ffa500;\n" +
            "}\n" +
            ".register_button span {\n" +
            "  font-weight: normal;\n" +
            "  font-size: 28px;\n" +
            "  line-height: 40px;\n" +
            "}\n" +
            ".register_button span a {\n" +
            "  text-decoration: none;\n" +
            "  color: white;\n" +
            "}\n" +
            ".register_button span a:hover {\n" +
            "  background-color: white;\n" +
            "  color: #ffa500;\n" +
            "}</style>";
}
