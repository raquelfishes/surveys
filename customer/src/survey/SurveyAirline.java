package survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import questions.Questions;
import questions.QuestionsAirline;

/* This class make the airline survey */

public class SurveyAirline {
		
	private Questions quest;
				
		public SurveyAirline(PrintWriter pw){
			quest = new QuestionsAirline(pw);
		}
		
		//Write the welcome message
		public void writeintro() {
			System.out.println ("Welcome to the survey about our airline company.\nWe want make you a few questions about our service.");			
		}

		// Get the questions for the survey with a random, to choose only 5 questions
		public ArrayList<Integer> getquestions() {
			ArrayList<Integer> nquest = new ArrayList<Integer>();
			nquest.clear();
			int aux = 13;
			Random ra = new Random(aux);
			for (int i=0; i<5; i++){
				int q = ra.nextInt(aux);
				while (nquest.contains(q))
					q = ra.nextInt();
				nquest.add(q);
			}
			nquest.add(13);
			return nquest;
		}
		
		// Make the question to the user, calling throw the questions class
		public void makequestions() throws IOException{
			ArrayList <Integer>aux = getquestions();
			Iterator<Integer> it = aux.iterator();
			while (it.hasNext()){
				int q = it.next();
				quest.makequestion(q);
			}			
		}
		
		// Make the survey
		public void makesurvey() throws IOException{
			writeintro();
			makequestions();
		}		
}
