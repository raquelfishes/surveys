package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import survey.SurveyAirline;
import survey.SurveyRestaurant;



public class MainClass{
	private static int type;
	private File file; // File where write all survey information
	private FileWriter f;
	private BufferedWriter bw;
	private static PrintWriter pw;
	private String filename; // Name of file

	public MainClass(){		
		filename = "C://Users//Raquel//Documents//survey.txt";
		file = new File (filename);
	}
	
	// Beggining of the survey. It verifys that the file exists and write the survey header
	public void newsurvey() throws IOException{
		testfile();
		f = new FileWriter(file, true);
		bw = new BufferedWriter(f);
		pw = new PrintWriter(bw);
		String aux;
		if (type == 1)
			aux = "airline";
		else
			aux = "restaurant";
		
		pw.append("New survey about:"+aux);
		pw.println();
	}
	
	// End of the survey. It closses the file and all open variables
	public void closesurvey() throws IOException{
		pw.println("End of survey.");
		pw.close();
		bw.close();
		f.close();
	}

	// Verify that the file exists. It it doesn't, it'll create it.
	public void testfile() throws IOException{
		if (!file.exists())
			file.createNewFile();
	}
	
	
	public static void main(String[] args) throws IOException{
		MainClass m = new MainClass();
		System.out.println ("What kind of survey do you want to answer? (1 = airline, 2 = restaurant)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		type = Integer.parseInt (br.readLine());
		SurveyAirline surveyair;
		SurveyRestaurant surveyres;
		m.newsurvey();
		if (type == 1){
			surveyair = new SurveyAirline(pw);
			surveyair.makesurvey();
		}
		else{
			surveyres = new SurveyRestaurant(pw);
			surveyres.makesurvey();
		}
		System.out.println ("Thank you for your time");
		m.closesurvey();
	}
	
}
