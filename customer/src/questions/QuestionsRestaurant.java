package questions;

import java.io.PrintWriter;


/* This class have the questions and possible answer for the question, about restaurant survey*/

public class QuestionsRestaurant extends Questions{
	
	private int nquest; // Number of questions
	
	public QuestionsRestaurant(PrintWriter pw){
		super(pw);
		nquest = 5;
		savequestions();
	}
	
	// Save the questions with their numbers, and save the kind of answer for the question
	public void savequestions(){
		for (int i=0; i<nquest+1; i++){
			switch (i){
			case 0: questions.put(i, "What can we do better?");
					answers.put(i, 3);
					break;
			case 1: questions.put(i, "Do you want give us more feedback?");
					answers.put(i, 1);
					break;
			case 2: questions.put(i, "How good was the food?");
					answers.put(i, 2);
					break;
			case 3: questions.put(i, "How are the premises?");
					answers.put(i, 0);
					break;
			case 4: questions.put(i, "Are you happy with the service?");
					answers.put(i, 0);
					break;
			case 5: questions.put(i, "Would you come back?");
					answers.put(i, 1);
					break;
			}
		}
	}
	
	
}
