package survey;

import java.util.ArrayList;
import java.util.HashMap;

/* This class save the questions and the kind of answers*/

public class Questions {

	private HashMap<Integer,Integer> answers; //Number of question - Kind of answer
	private HashMap<Integer,ArrayList<String>> kindanswer; //Kind of answer - Potential answers
	
	public Questions(int i){
		answers = new HashMap<Integer,Integer>();
		kindanswer = new HashMap<Integer,ArrayList<String>>();
		saveanswers(i);
		savekinds();
	}
	
	// Save the kind of answers for each question
	public void saveanswers(int t){
		switch (t){
		case 1: for(int i=0; i<14; i++)
					switch(i){
					case 0:
					case 1:
					case 2:
					case 4:
					case 5: answers.put(i, 0);
							break;
					case 3:
					case 6:
					case 8:
					case 9:
					case 10:
					case 11: answers.put(i, 1);
							 break;
					case 7:
					case 12: answers.put(i, 2);
							 break;
					case 13: answers.put(i, 3);
							 break;
					}
				break;
		case 2: for(int i=0; i<6; i++)
					switch(i){
					case 3:
					case 4: answers.put(i, 0);
							break;
					case 1:
					case 5: answers.put(i, 1);
							break;
					case 2: answers.put(i, 2);
							break;
					case 0: answers.put(i, 3);
					}
				break;
		}
	}
	
	// Save the potential answers for each kind
	public void savekinds(){
		for (int i=0; i<4; i++){
			ArrayList<String> aux = new ArrayList<String>();
			aux.clear();
			switch(i){
			case 0: aux.add("satisfied");
					aux.add("neutral");
					aux.add("unsatisfied");
					kindanswer.put(i, aux);
					break;
			case 1: aux.add("yes");
					aux.add("no");
					kindanswer.put(i,aux);
					break;
			case 2: aux.add("1");
					aux.add("2");
					aux.add("3");
					aux.add("4");
					aux.add("5");
					kindanswer.put(i, aux);
					break;
			case 3: kindanswer.put(i, aux);
					break;
			}
		}
	}
	
	// Return the number of potential answers in a question
	public int getnumanswers(int k){
		int aux = answers.get(k); //Tipo de respuesta
		switch(aux){
		case 0: return 3;
		case 1: return 2;
		case 2: return 5;
		default: return -1;
		}
	}
	
	// Return the position of the answer, on the arraylist of potential answers
	public int getanswer(int k, String a){ 
		int aux = answers.get(k);
		return kindanswer.get(aux).indexOf(a);
	}
	
	// Return if the question number k is a text question
	public boolean testanswer(int k){
		return (answers.get(k) == 3);
	}
	
	
}
