/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Rahul
 */
public class insertForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet insertForm</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
            out.println("<h2>Add Student Data</h2>");
            out.println("<hr width='10%' />");
            out.println("<br />");
        out.println("</center>");    
        out.println("<form action='insert' method='get'>");
        out.println("<table border='1' style='border-collapse:collapse;' align='center'>");
            out.println("<tr>");
                out.println("<td>");
                    out.println("<label>Full Name</label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='name' id='name' />");
                out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>");
                    out.println("<label>Email</label>");
                out.println("</td>");    
                out.println("<td>");
                    out.println("<input type='email' name='email' id='email' />");
                out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>");
                    out.println("<label>Contact Number</label>");
                out.println("</td>");    
                out.println("<td>");
                    out.println("<input type='text' name='number' id='number' />");
                out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td colspan='2'>");
                    out.println("<center>");
                        out.println("<br />");
                        out.println("<input type='submit' name='submit' id='submit' />");
                    out.println("</center>");    
                        out.println("<br />");
                out.println("</td>");
            out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
