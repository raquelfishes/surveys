package questions;

import java.io.PrintWriter;


/* This class have the questions and possible answer for the question, about airline survey*/

public class QuestionsAirline extends Questions{

	private int nquest; // Number of questions
	
	public QuestionsAirline(PrintWriter pw){
		super(pw);
		nquest = 13; 
		savequestions();
	}
	
	// Save the questions with their numbers, and save the kind of answer for the question
	public void savequestions(){
		for (int i=0; i<nquest+1; i++){
			switch (i){
			case 0: questions.put(i, "Are you happy with the service?");
					answers.put(i, 0);
					break;
			case 1: questions.put(i, "Was the waiting time OK?");
					answers.put(i, 0);
					break;
			case 2: questions.put(i, "Are you happy with the ground staff?");
					answers.put(i, 0);
					break;
			case 3: questions.put(i, "Did you use the online check-in service?");
					answers.put(i, 1);
					break;
			case 4: questions.put(i, "How would you rate the punctuality of your flight?");
					answers.put(i, 0);
					break;
			case 5: questions.put(i, "How satisfied are you with the onboard crew?");
					answers.put(i, 0);
					break;
			case 6: questions.put(i, "Have you heard about our last-minute offers?");
					answers.put(i, 1);
					break;
			case 7: questions.put(i, "How do you rate the airplane cabin?");
					answers.put(i, 2);
					break;
			case 8: questions.put(i, "Have you used our in-cabin entertainment systems?");
					answers.put(i, 1);
					break;
			case 9: questions.put(i, "Have you bought any item in-flight?");
					answers.put(i, 1);
					break;
			case 10: questions.put(i, "Do you know about our new tourist-plus class?");
					answers.put(i, 1);
					break;
			case 11: questions.put(i, "Are you travelling for business?");
					answers.put(i, 1);
					break;
			case 12: questions.put(i, "How would you rate us?");
					answers.put(i, 2);
					break;
			case 13: questions.put(i, "If you want to leave a comment, you can write whatever you want now.");
					answers.put(i, 3);
					break;
			}
		}
	}		
}
