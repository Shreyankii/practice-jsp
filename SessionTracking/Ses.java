package com.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ses")
public class Ses extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
		
		
		int n = Integer.parseInt(req.getParameter("num1"));
		
		HttpSession session = req.getSession();
		
		session.setAttribute("k", n);
		
		resp.sendRedirect("Ses2");
	
	}


}
