package com.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 
	 String username = req.getParameter("username");
	 String password = req.getParameter("password");
	 
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String URL = "jdbc:mysql://localhost:3306/Register";
        String USER = "root";
        String PASS = "NewPassword123!";
        
        
        Connection con = DriverManager.getConnection(URL, USER, PASS);
         
        
        PreparedStatement ps = con.prepareStatement( "SELECT * FROM LOGIN WHERE username=? AND password=?");
        
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resp.getWriter().write("<h2>login Successful!</h2>");
        } else {
            resp.getWriter().write("<h2>login Failed!</h2>");
        }


        con.close();

 
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
		
	}
	}

}
