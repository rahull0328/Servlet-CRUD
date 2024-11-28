/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package crud;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author Rahul
 */

public class viewData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body bgcolor= 'pink'>");
        out.println("<center><h1> CRUD - Servlet<h1><Center>");
        out.println("<hr width='20%' />");
        out.println("<table border='1' align='center'>");
        out.println("<tr>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Mobile</th>");
        out.println("<th>Action</th>");
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            String query = "SELECT * FROM data";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + " </td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("mobile") + "</td>");
                out.println("<td>");
                out.println("<a href='delete?id="+rs.getString("id")+"' style='text-decoration: none;' />Delete&nbsp;&nbsp;|&nbsp;");
                out.println("<a href='updateForm?id="+rs.getString("id")+"' style='text-decoration: none;' />Update");
                out.println("</td>");
                out.println("</tr>");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        out.println("</table>");
        out.println("<br />");
        out.println("<a href='insertForm' style='text-decoration: none;' />Add Data");
        out.println("</body>");
        out.println("</html>");
    }
}
