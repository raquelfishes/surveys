package survey;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import data.StudyDatas;

/* This class save all the results from the file, in variables */
public class ReadSurveys {

	private Questions quest;
	private int nsurveys;
	private ArrayList<HashMap<Integer, Integer>> answers; //Number of question - (kind answer - number of answers)
	private ArrayList<String> comments; //Text answers
	private int type;
	private StudyDatas sd;
	
	public ReadSurveys(int i){
		type = i;
		quest = new Questions(i);
		answers = initializeanswers();
		comments = new ArrayList<String>();
	}
	
	// Save the answers depending on the type of survey (airline or restaurant)
	public ArrayList<HashMap<Integer,Integer>> initializeanswers(){
		ArrayList<HashMap<Integer,Integer>> aux = new ArrayList<HashMap<Integer,Integer>>();
		if (type == 1)
			for (int i=0; i<14; i++)
				aux.add(i,initializeanswer(i));
		else
			for (int i=0; i<6; i++)
				aux.add(i,initializeanswer(i));
		return aux;
	}
	
	// Save the initial values for each question. All results of the questions are 0
	public HashMap<Integer,Integer> initializeanswer(int n){
		HashMap<Integer,Integer> aux = new HashMap<Integer,Integer>();
		int nanswer = quest.getnumanswers(n);
		for (int i=0; i<nanswer; i++)
			aux.put(i, 0);
		return aux;
	}
	
	// Analize the kind of survey.
	public boolean newsurvey(String s){
		String[] words = s.split(":");
		int auxtype = -1;
		if (words[1].equals("airline"))
			auxtype = 1;
		else if (words[1].equals("restaurant"))
			auxtype = 2;
		if (auxtype == type){
			nsurveys++;
			return true;
		}
		return false;		
	}
	
	// Save all the questions for a survey.
	public String savequestions(Scanner f){
		String aux = "End of survey.";
		String line = "";
		while (f.hasNext() && !line.equals(aux)){
			line = f.nextLine();
			if (!line.equals(aux))
				savequestion(line);
		}
		return line;
	}
	
	// Save the valor for each questions, and depending for the kind of answer
	public void savequestion(String s){
		HashMap<Integer, Integer> aux = new HashMap<Integer,Integer>();
		String[] words = s.split(" : ",2);
		int q = Integer.parseInt(words[0]); //a = nº pregunta
		if (quest.testanswer(q)){
			aux.put(0, -1);
			answers.remove(q);
			answers.add(q, aux);
			if (!words[1].equals(""))
				comments.add(words[1]);
		}
		else{
			int a = quest.getanswer(q, words[1]); //Posicion de la respuesta dada en el string de respuestas del mismo tipo
			aux = answers.get(q);	//actuales respuestas
			int i = aux.get(a)+1; //actual numero de respuestas iguales
			aux.put(a, i);
			answers.remove(q);
			answers.add(q, aux);
		}		
	}
	
	// Moves to reach the next survey on the file
	public void nextsurvey(Scanner f, String s){
		String line = s;
		String aux = "End of survey.";
		while (f.hasNext() && !line.equals(aux)){
			if (!line.equals(aux))
				line = f.nextLine();
		}
	}
	
	// Inits the study.
	public void newstudy(Scanner f){
		String line = f.nextLine();
		while (f.hasNext()){		
			if (newsurvey(line) == true)
				line = savequestions(f);
			nextsurvey(f,line);
			if (f.hasNext())
				line = f.nextLine();
		}
		sd = new StudyDatas(nsurveys,answers,comments);
		sd.writeresults();
	}	
}
