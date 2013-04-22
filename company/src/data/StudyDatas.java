package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* This class show the results about the surveys response */

public class StudyDatas {

	private int num;
	private ArrayList<HashMap<Integer, Integer>> answers;
	private ArrayList<String> comments;
	
	
	public StudyDatas(int n, ArrayList<HashMap<Integer, Integer>> a, ArrayList<String> c){
		num = n;
		answers = a;
		comments = c;
	}
	
	// Write the number of people who have answered the survey
	public void writeresults(){
		System.out.println(num + " persons have answered your survey.");
		if (num != 0)
			writeanswers();
	}
	
	// Write all the results for each question
	public void writeanswers(){
		for (int i=0; i<answers.size(); i++){
			System.out.println("Question number " + (i+1));
			if (answers.get(i).get(0) == -1){
				System.out.println("Kind of answer " + "user text.");
				writecomments();
			}
			else{
				int size = answers.get(i).size();
				HashMap<Integer, Integer> aux = answers.get(i);
				if (size == 2){
					System.out.println("Kind of answer " + "yes/no");
					writeyesno(aux);
				}
				else if (size == 3){
					System.out.println("Kind of answer " + "satisfied/neutral/unsatisfied");
					writesatisfied(aux);
				}
				else{
					System.out.println("Kind of answer " + "Value between 1-5");
					writevalues(aux);
				}
			}
						
		}
	}
	
	// Write the results for text question
	public void writecomments(){
		System.out.println(comments.size() + " persons have commented.");
		Iterator<String> it = comments.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	// Write the results for yes/no questions
	public void writeyesno(HashMap<Integer, Integer> aux){
		for (int i=0; i<2; i++){
			int n = 0;
			if (aux.get(i) == null)
				n = 0;
			else
				n = aux.get(i);
			switch(i){
			case 0: System.out.println("YES -> "+ n);
					break;
			case 1: System.out.println("NO -> "+ n);
					break;
			}
		}
	}
	
	// Write the results for satisfied/neutral/unsatisfied questions
	public void writesatisfied(HashMap<Integer, Integer> aux){
		for (int i=0; i<3; i++){
			int n = 0;
			if (aux.get(i) == null)
				n = 0;
			else
				n = aux.get(i);
			
			switch(i){
			case 0: System.out.println("SATISFIED ->: "+ n);
					break;
			case 1: System.out.println("NEUTRAL -> "+ n);
					break;
			case 2: System.out.println("UNSATISFIED -> "+ n);
			break;
			}
		}
	}
	
	// Write the results for 1-5 questions
	public void writevalues(HashMap<Integer, Integer> aux){
		for (int i=1; i<=5; i++){
			int n = 0;
			if (aux.get(i) == null)
				n = 0;
			else
				n = aux.get(i);
			System.out.println(i + " -> "+ n);
		}
	}
	
	
}
