/**
 * 
 */
package net.mirgiga.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;


public class Utility {
	//container for user sessions
	public static Map <HttpSession, User> sessions = new ConcurrentHashMap <>();
	
	//will form user question random from XML file, now it hardcoded.
	public static void quizeGenerator (User user){
		Question q = new Question();
		q.questionText="Под каким кустом сидит заяц во время дождя?";
		q.answers.add("Под осиновым");
		q.answers.add("Под березовым");
		q.answers.add("Под мокрым");
		q.correctAnswers.add("Под мокрым");
		user.questionsList.add(q);
	
		
		q = new Question();
		q.questionText="Почему ветер дует?";
		q.answers.add("Бабка нашептала");
		q.answers.add("Деревья качаются");
		q.answers.add("Перемещение воздушной массы из области высокого давления в область низкого");
		q.correctAnswers.add("Перемещение воздушной массы из области высокого давления в область низкого");
		user.questionsList.add(q);
	
		
		q = new Question();
		q.questionText="Почему у главного героя усы как у тов. Сталина? Полагаю, режисера надо...?";
		q.answers.add("Расстрелять");
		q.answers.add("Побрить");
		q.answers.add("Сделать прививку от дифтерии");
		q.correctAnswers.add("Побрить");
		q.correctAnswers.add("Сделать прививку от дифтерии");
		user.questionsList.add(q);
	
		q = new Question();
		q.questionText="Есть ли в США 23 февраля?";
		q.answers.add("Да");
		q.answers.add("Нет");
		q.answers.add("Только у военнослужащих");
		q.answers.add("Только у мужчин");
		q.correctAnswers.add("Да");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="Винни-пух - это..";
		q.answers.add("Поросенок");
		q.answers.add("Свинья");
		q.answers.add("Хряк");
		q.answers.add("Кабан");
		q.answers.add("Нечто иное");
		q.correctAnswers.add("Нечто иное");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="Журналисты наврали, что бздыш болотный безграмотен и нахален";
		q.answers.add("На самом деле бздыш болотный образован и тактичен");
		q.answers.add("На самом деле бздыш болотный безграмотен, но не нахален");
		q.answers.add("Те журналисты таки соврали");
		q.correctAnswers.add("Те журналисты таки соврали");
		user.questionsList.add(q);
		
		
		q = new Question();
		q.questionText="У Мамеда 10 овец. Все, кроме 9, сдохли. Сколько осталось у мамеда овец?";
		q.answers.add("Одна");
		q.answers.add("Девять");
		q.answers.add("Десять");
		q.correctAnswers.add("Девять");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="У Ицхака горело 7 свечей, 3 он потушил перед сном. Сколько свечей осталось?";
		q.answers.add("Одна");
		q.answers.add("Три");
		q.answers.add("Четыре");
		q.answers.add("Десять");
		q.correctAnswers.add("Три");
		user.questionsList.add(q);
	}
	
	public static int getResultScore(User user){
		int score = 0;
		
		for (Question c : user.questionsList){
			if (c.checkedAnswers.equals(c.correctAnswers)) score++;
		}
		
		return score;
	}
}

