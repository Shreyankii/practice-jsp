package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ses2")
public class Ses2 extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  
		HttpSession session = req.getSession();
		int number = (int)session.getAttribute("k");
		
		PrintWriter out = resp.getWriter();
		
		
		out.print("square is " + number*number);
	}

}
