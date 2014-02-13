
package net.mirgiga.web;

import java.io.IOException;

import static  net.mirgiga.model.Utility.*;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mirgiga.model.User;


public class AreYouReady extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		String name = request.getParameter("username");
	//		Cookie cookie = new Cookie("username", name);
	//		cookie.setMaxAge(30*60);
	//		response.addCookie(cookie);
	//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if (session.isNew()){
			User newUser  = new User(name);
			quizeGenerator(newUser); // set questions for this user
			sessions.put(session,newUser);
		} else {
			//error
			System.out.println ("session is old");
		}
	
		
		request.setAttribute("name", name);
		RequestDispatcher view = request.getRequestDispatcher("ready.jsp");
		view.forward(request, response);
	}
}
