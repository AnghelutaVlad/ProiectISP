package Ambalare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Segment_brat {
	private int Lungime;
	private int Latime;
	private boolean Gripper;
	
	public Segment_brat(int lun, int lat, boolean st) {
		this.Lungime = lun;
		this.Latime = lat;
		this.Gripper = st;
	}
	
	public void afisare() {
		System.out.println("Lungime: "+this.Lungime);
		System.out.println("Latime: "+this.Latime);
		System.out.println("Are gheara: "+this.Gripper);
	}
	
	public void salvare(String numeFisier, File logFile) {

    	PrintWriter filePrint;

    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("         Lungime: " + this.Lungime);
    		filePrint.println("         Latime: " + this.Latime);
    		filePrint.println("         Are gheara: " + this.Gripper);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
	
	public int getLungime() {
		return Lungime;
	}

}
