package Ambalare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Random;

public class Robot {
	protected int ID;
	protected LocalDate Data_achizitionare;
	protected int Greutate;
	protected StareRobot Stare;
	protected LocalDate Data_revizie;
	protected int Capacitate;
	
	public Robot(int id, LocalDate ach, int g,StareRobot st,LocalDate rev, int c) {
		this.ID = id;
		this.Capacitate = c;
		this.Data_achizitionare = ach;
		this.Stare = st;
		this.Data_revizie = rev;
		this.Greutate = g;
	}
	
	public void afisare() {
		System.out.println("ID: "+this.ID);
		System.out.println("Data achizitionare: "+this.Data_achizitionare);
		System.out.println("Greutate: "+this.Greutate);
		System.out.println("Stare: "+this.Stare);
		System.out.println("Data revizie: "+this.Data_revizie);
		System.out.println("Capacitate: "+this.Capacitate);
	}
	
	
	public void salvare(String numeFisier, File logFile) {
    	PrintWriter filePrint;

    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("      ID: " + this.ID);
    		filePrint.println("      Data achizitionare: " + this.Data_achizitionare);
    		filePrint.println("      Greutate: " + this.Greutate);
    		filePrint.println("      Stare: " + this.Stare);
    		filePrint.println("      Data ultimei revizii: " + this.Data_revizie);
    		filePrint.println("      Capacitate maxima: " + this.Capacitate);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
	
	public void SetStare(StareRobot s) {
		this.Stare = s;
	}
	public StareRobot GetStare() {
		return Stare;
	}
	public void DeplasareObiecte() {
		this.Stare = StareRobot.Activ;
		
		Random rand = new Random();
		int sansa = rand.nextInt(20) + 1;
		if (sansa >= 18)
			this.Stare = StareRobot.Defect;
		
	}
	public int GetCapacitate() {
		return Capacitate;
	}
	public int GetID()
	{
		return ID;
	}
	

}
