/**
 * 
 */
package net.mirgiga.web;

import static net.mirgiga.model.Utility.sessions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Result extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("doGet in result.java");
		if (!sessions.containsKey(session)){
			System.out.println("session wrong");
		}
		else{
			session.invalidate();
			System.out.println("response.sendRedirect");
			response.sendRedirect("index.html");
			
		}
	}
}
