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
public class delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        Connection con = null;
        try {
            //loading drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //establishing connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //preparing statement
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM data WHERE id = ?");
            pstmt.setString(1, id);
            
            int result = pstmt.executeUpdate();
            if(result > 0){
                resp.sendRedirect("viewData");
            } else {
                out.println("<p>Error Occured</p>");
            }
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }
    
}
