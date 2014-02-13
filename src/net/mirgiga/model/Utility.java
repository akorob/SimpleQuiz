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
		q.questionText="��� ����� ������ ����� ���� �� ����� �����?";
		q.answers.add("��� ��������");
		q.answers.add("��� ���������");
		q.answers.add("��� ������");
		q.correctAnswers.add("��� ������");
		user.questionsList.add(q);
	
		
		q = new Question();
		q.questionText="������ ����� ����?";
		q.answers.add("����� ���������");
		q.answers.add("������� ��������");
		q.answers.add("����������� ��������� ����� �� ������� �������� �������� � ������� �������");
		q.correctAnswers.add("����������� ��������� ����� �� ������� �������� �������� � ������� �������");
		user.questionsList.add(q);
	
		
		q = new Question();
		q.questionText="������ � �������� ����� ��� ��� � ���. �������? �������, �������� ����...?";
		q.answers.add("�����������");
		q.answers.add("�������");
		q.answers.add("������� �������� �� ��������");
		q.correctAnswers.add("�������");
		q.correctAnswers.add("������� �������� �� ��������");
		user.questionsList.add(q);
	
		q = new Question();
		q.questionText="���� �� � ��� 23 �������?";
		q.answers.add("��");
		q.answers.add("���");
		q.answers.add("������ � ��������������");
		q.answers.add("������ � ������");
		q.correctAnswers.add("��");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="�����-��� - ���..";
		q.answers.add("���������");
		q.answers.add("������");
		q.answers.add("����");
		q.answers.add("�����");
		q.answers.add("����� ����");
		q.correctAnswers.add("����� ����");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="���������� �������, ��� ����� �������� ����������� � �������";
		q.answers.add("�� ����� ���� ����� �������� ��������� � ��������");
		q.answers.add("�� ����� ���� ����� �������� �����������, �� �� �������");
		q.answers.add("�� ���������� ���� �������");
		q.correctAnswers.add("�� ���������� ���� �������");
		user.questionsList.add(q);
		
		
		q = new Question();
		q.questionText="� ������ 10 ����. ���, ����� 9, ������. ������� �������� � ������ ����?";
		q.answers.add("����");
		q.answers.add("������");
		q.answers.add("������");
		q.correctAnswers.add("������");
		user.questionsList.add(q);
		
		q = new Question();
		q.questionText="� ������ ������ 7 ������, 3 �� ������� ����� ����. ������� ������ ��������?";
		q.answers.add("����");
		q.answers.add("���");
		q.answers.add("������");
		q.answers.add("������");
		q.correctAnswers.add("���");
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

