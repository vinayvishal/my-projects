package com.example;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@WebServlet("/")
public class DSServlet extends HttpServlet {

    @Resource(name = "jdbc/__default")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = ds.getConnection();
            System.out.println("Connection got established successfully.");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select name, org from employee");

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.print("<html><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>Employee Name</th>");
            out.print("<th>Employee Org</th>");

            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getString("name") + "</td>");
                out.print("<td>" + rs.getString("org") + "</td>");
                out.print("</tr>");
            }
            out.print("</table></body><br/>");

            //lets print some DB information
            out.print("<h3>Database Details</h3>");
            out.print("Database Product: " + con.getMetaData().getDatabaseProductName() + "<br/>");
            out.print("Database Driver: " + con.getMetaData().getDriverName());
            out.print("</html>");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    System.out.println("result set can be obtained");


                } else {
                    System.out.println("result set can't be obtained");
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Exception in closing DB resources");
            }

        }
    }

}
