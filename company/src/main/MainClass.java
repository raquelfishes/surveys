package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import survey.ReadSurveys;

/* Main Class to init all the variables*/

public class MainClass {

	private static int type;
	private String filename;
	private static File file;
	
	public MainClass(){
		filename = "C://Users//Raquel//Documents//survey.txt";
		file = new File (filename);
	}
	// Verify that the file exists. It it doesn't, it show the warning message.
	public boolean testfile() throws IOException{
		if (!file.exists()){
			System.out.println("The file doesn't exists");
			return false;
		}
		return true;			
	}
	
	
	public static void main(String[] args) throws IOException{
		MainClass ms = new MainClass();
		System.out.println ("What kind of company are you? (1 = airline, 2 = restaurant)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		type = Integer.parseInt (br.readLine());
		boolean b = ms.testfile();
		if (b){
			Scanner f = new Scanner(file);
			ReadSurveys rs = new ReadSurveys(type);
			rs.newstudy(f);
		}
		System.out.println ("Thank you for your time");
	}
	
}
