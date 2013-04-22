package questions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* This class has information about the common methods for the questions*/

public class Questions {

	protected HashMap<Integer,String> questions; // Number of question - Text of question
	protected HashMap<Integer,Integer> answers; // Number of question - Kind of answer
	private HashMap<Integer,ArrayList<String>> kindanswer; // Kind of answer - Potential answer
	private String lastanswer; // Written answer last
	private PrintWriter pw;
	
	
	public Questions(PrintWriter pw){
		questions = new HashMap<Integer,String>();
		answers = new HashMap<Integer,Integer>();
		kindanswer = new HashMap<Integer,ArrayList<String>>();
		saveanswers();
		this.pw = pw;
	}
	
	// Return the written answer last for the user
	public String getlastanswer(){
		return lastanswer;
	}
	
	// Save the potential response of each type of response
	public void saveanswers(){
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
			case 3: kindanswer.put(i, null);
					break;
			}
		}
	}
	
	// Test of the last answer. If the response isn't defined on this question, it'll write a warning message.
	public boolean correctanswer(String s, int t){
		if (kindanswer.get(t) == null)
			return true;
		else if (kindanswer.get(t).contains(s))
			return true;
		else
			wronganswer();
			return false;
	}
	
	// Warning message when response isn't correct
	public void wronganswer(){
		System.out.println("Your answer is incorrect. Please type one of the options listed.");
	}
	
	// Make the question number i
	public void makequestion(int i) throws IOException{
		System.out.println(questions.get(i));
		writeanswers(i);
		readanswer(i);
	}
	
	// Write the possible response
	public void writeanswers(int i){
		int type = answers.get(i);
		if (type != 3){
			Iterator<String> it = kindanswer.get(type).iterator();
			while (it.hasNext())
				System.out.print(it.next()+"/");
			System.out.println();
		}
	}
	
	// Read the last answer, and check it. If it's wrong, show again the possible answer and wait for a new response
	public void readanswer(int i) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        lastanswer = answer;
        while (!correctanswer(answer,answers.get(i))){
        	writeanswers(i);
        	answer = br.readLine();
        	lastanswer = answer;
        }
        saveanswer(answer,i);
	}
	
	// Save the response on a file with all the answers a surveys
	public void saveanswer(String s, int i){
		pw.print(i + " : " + s);
		pw.println();
	}
}
