package Ambalare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class BratRobotic extends Robot {
	private int Nr_segmente;
	private ArrayList<Integer> Unghiuri_segmente;
	private ArrayList<Segment_brat> Segmente;
	
	public BratRobotic(int id, LocalDate ach, int g,StareRobot st,LocalDate rev, int c, ArrayList<Integer> vi, ArrayList<Segment_brat> vs) {
		super(id,ach,g,st,rev,c);
		this.Nr_segmente = vs.size();
		this.Segmente = vs;
		this.Unghiuri_segmente = vi;
	}
	
	public void afisare() {
		super.afisare();
		System.out.println(this.Nr_segmente+" segmente");
		System.out.println("Unghiuri: ");
		for(int i = 0;i < Unghiuri_segmente.size();i++) {
			System.out.println("Unghi "+(i+1)+": "+Unghiuri_segmente.get(i));
		}
		System.out.println("Segmente: ");
		for(int i = 0; i < Segmente.size();i++) {
			System.out.println("Segment "+(i+1));
			Segmente.get(i).afisare();
		}
		
	}
	
	public void salvare(String numeFisier, File logFile) {

    	PrintWriter filePrint;    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("Brat robotic: ");
    		super.salvare(numeFisier, logFile);
    		filePrint.println("      Nr segmente: " + this.Nr_segmente);
    		filePrint.println("      Unghiuri: ");
    		for(int i = 0;i < Unghiuri_segmente.size();i++) {
    			filePrint.println("         Unghi "+(i+1)+": "+Unghiuri_segmente.get(i));
    		}
    		filePrint.println("      Segmente: ");
    		for(int i = 0; i < Segmente.size();i++) {
    			filePrint.println("         Segment "+(i+1));
    			Segmente.get(i).salvare(numeFisier, logFile);
    		}
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
	
	public int GetRazaActiune() {
		int raza = 0;
		for(int i = 0; i < Segmente.size();i++) {
			raza += Segmente.get(i).getLungime();
		}
		return raza;
	}
	public void AmbalarePachet(Pachet p) {
		p.SetStare(StarePachet.Ambalat);
	}
	
	public void SortareObiect(Pachet p, Conveior c_out, Conveior c_in) {
		c_out.Elimina_pachet(p.GetID());
		c_in.Adauga_pachet(p);
	}
	
	public void EliminaRebut(Pachet p, RobotMobil m, ArrayList<Pachet> vr) {
		m.DeplasarePachet(p,vr);
	}
	
	public void PlasarePachet(Conveior c, ArrayList<Pachet> vp)
	{
		for (int i = 0; i < vp.size(); i++)
			c.Adauga_pachet(vp.get(i));
	}
	
}
