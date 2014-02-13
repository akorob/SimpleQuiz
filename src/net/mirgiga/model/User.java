/**
 * 
 */
package net.mirgiga.model;

import java.util.ArrayList;
import java.util.*;

public class User{
	public String name;
	public int currentQuestion =0;
	public List <Question> questionsList = new ArrayList<>();
	//public List <Answer> userAnswList = new ArrayList<>();
	//public Map <Question, Answer> quizMap = new HashMap<>();
	public int time=20*60 ; //20 min for quiz
	public User (String name){
		this.name=name;
	}
}