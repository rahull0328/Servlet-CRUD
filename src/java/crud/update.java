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
public class update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String mobile = req.getParameter("mobile");
            Connection con = null;
            
            try{
                //loading drivers
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                //establishing connection 
                con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
                //preparing query
                PreparedStatement pstmt = con.prepareStatement("UPDATE data SET name = ?, email = ?, mobile = ? WHERE id = ?");
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, mobile);
                pstmt.setString(4, id);
                int rowInserted = pstmt.executeUpdate();
                
                if (rowInserted > 0) {
                    // Redirect to viewData page after successful insertion
                    resp.sendRedirect("viewData");
                } else {
                    out.print("failed updating data!");
                }
            } catch (Exception ex) {
               out.print(ex.getMessage());
          }
    }
}
