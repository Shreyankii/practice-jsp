package com.cook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ggg")
public class ggg extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String n1 =request.getParameter("username");
        
        PrintWriter out = response.getWriter();
        
        boolean visited = (false);
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null) {
        	for (Cookie cookie : cookies) {
        		
        		Cookie c = cookie;
        		
        		String name = c.getName();
        		
        		String val = c.getValue();
        		
        		if (name.equals("k")&& val.equals("123")) {
        			
        			out.print("welcome back");
        			
        			visited=true;
        			
        			break;
					
				}
				
			}
        }
        
        if(!visited) {
        	
        	out.print("welcome 1st time");
            Cookie c = new Cookie("k", "123");
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }

	}

}
