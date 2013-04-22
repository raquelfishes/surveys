package survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import questions.Questions;
import questions.QuestionsRestaurant;

public class SurveyRestaurant{
	
	private Questions quest;
	private boolean morequestions;
	
		public SurveyRestaurant(PrintWriter pw){
			quest = new QuestionsRestaurant(pw);
			morequestions = false;
		}
		
		public void writeintro() {
			System.out.println ("Welcome to the survey about our restaurant.\nWe want make you a few questions about our service.");			
		}
	
		// Save the optional questions.
		public ArrayList<Integer> getoptionalquestions() {
			ArrayList<Integer> nquest = new ArrayList<Integer>();
			for (int i=2; i<6; i++){
				nquest.add(i);
			}
			return nquest;
		}
		
		// Make the question to the user, calling throw the questions class
		public void makequestions() throws IOException{
			ArrayList<Integer>aux = getoptionalquestions();
			obligatoryquestions();
			if (morequestions){
				Iterator<Integer> it = aux.iterator();
				while (it.hasNext()){
					int q = it.next();
					quest.makequestion(q);
				}
			}
		}
		
		// At first, make the first two compulsory questions, and analyzes whether the user wants to continue answering other questions or not
		public void obligatoryquestions() throws IOException{
			quest.makequestion(0);
			quest.makequestion(1);
			morequestions = false;
			if (quest.getlastanswer().equals("yes"))
				morequestions = true;			
		}
		
		// Make the survey
		public void makesurvey() throws IOException{
			writeintro();
			makequestions();
		}		

}
