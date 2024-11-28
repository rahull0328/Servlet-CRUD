/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 *
 * @author Rahul
 */
public class updateForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userId = req.getParameter("id");
        Connection con = null;
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet insertForm</title>");
        out.println("</head>");
        out.println("<body bgcolor='cyan'>");
        out.println("<center>");
        out.println("<h2>Update Student Data</h2>");
        out.println("<hr width='10%' />");
        out.println("<br />");
        out.println("</center>");
        out.println("<form action='update' method='get'>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            String query = "SELECT * FROM data WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(userId));
            ResultSet rs = stmt.executeQuery();
            String id = "";
            while(rs.next()) {
                rs.getString("id");
                out.println("<table border='1' style='border-collapse:collapse;' align='center'>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type='hidden' name='id' value="+ rs.getString("id") +" />");
                out.println("<label>Full Name</label>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type='text' name='name' value=" + rs.getString("name") + " id='name' />");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<label>Email</label>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type='email' name='email' value=" + rs.getString("email") + " id='email' />");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<label>Contact Number</label>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type='text' name='mobile' value=" + rs.getString("mobile") + " id='mobile' />");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan='2'>");
                out.println("<center>");
                out.println("<br />");
                out.println("<input type='submit' value='Update' name='submit' id='submit' />");
                out.println("</center>");
                out.println("<br />");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        out.println("</form>");
        out.println("<br />");
        out.println("<center><a href='viewData' style='text-decoration: none;' />View Data</center>");
        out.println("</body>");
        out.println("</html>");
    }

}
