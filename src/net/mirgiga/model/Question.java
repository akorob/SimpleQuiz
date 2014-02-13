/**
 * 
 */
package net.mirgiga.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	public String questionText;
	public List <String> answers = new ArrayList<>();
	public List <String> correctAnswers = new ArrayList<>();
	public List <String> checkedAnswers = new ArrayList<>();
	
	public Question (String questionText, List<String> answers, List<Integer> correctAnswerIndexes){
		this.questionText = questionText;
		this.answers = answers;
		this.correctAnswers = correctAnswers;
	}
	
	public Question() {
	}
}