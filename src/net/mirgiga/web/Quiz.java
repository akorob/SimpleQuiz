/**
 * 
 */
package net.mirgiga.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static  net.mirgiga.model.Utility.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mirgiga.model.Question;
import net.mirgiga.model.User;

public class Quiz extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("do POST in Quiz.java");
		
		HttpSession session = request.getSession();
		if (!sessions.containsKey(session)){
			System.out.println("sessin wrong in doPost!!!");
		}
		else{
			User user = sessions.get(session);
			Question currQues = user.questionsList.get(user.currentQuestion);
			String [] anAnsw = request.getParameterValues("answ");
			if (anAnsw!=null){ //one or more answers selected
				currQues.checkedAnswers.clear();
				currQues.checkedAnswers.addAll(Arrays.asList(anAnsw));
			} else System.out.println("null - no items selected");
			
			String act = request.getParameter("act");
			if (act.equals("Next")) {
				if (user.currentQuestion < user.questionsList.size()-1) 
					user.currentQuestion++;
				else user.currentQuestion=0;
				doGet(request, response);
		} else if (act.equals("Finish")){
				request.setAttribute("name", user.name);
				request.setAttribute("totalNumber", user.questionsList.size());
				request.setAttribute("resultScore", getResultScore(user));
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
		} else {
				System.out.println("someone has altered the HTML and sent a different value!");
			}
		}
	}
	
	 public void doGet(HttpServletRequest request,
             HttpServletResponse response) throws ServletException, IOException{
		
		 	// System.out.println("do GET");
		 	HttpSession session = request.getSession();
			if (!sessions.containsKey(session)){
				System.out.println("sessin wrong in doGet!!!");
			}
			else{
				User user = sessions.get(session);
				request.setAttribute("name", user.name);
				Question currQues = user.questionsList.get(user.currentQuestion);
				request.setAttribute("currQuesNum", user.currentQuestion+1);
				request.setAttribute("totalNumber", user.questionsList.size());
				request.setAttribute("questionText",currQues.questionText );
				request.setAttribute("availAnsw", currQues.answers);
				request.setAttribute("checkedAnsw", currQues.checkedAnswers);
				request.setAttribute("singleAnsw", (currQues.correctAnswers.size()==1));
				
				RequestDispatcher view = request.getRequestDispatcher("quiz.jsp");
				view.forward(request, response);
			}
	 }
}
