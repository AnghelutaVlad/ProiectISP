package Ambalare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Conveior extends Robot {
	private int Lungime;
	private int Latime;
	private int Grosime;
	private int Viteza;
	private ArrayList<Pachet> Pachete_actuale;
	private int Nr_pachete;
	
	public Conveior(int id, LocalDate ach, int g,StareRobot st,LocalDate rev, int c,int lun, int lat, int gr, int vit, ArrayList<Pachet> vp) {
		super(id,ach,g,st,rev,c);
		this.Lungime = lun;
		this.Latime = lat;
		this.Grosime = gr;
		this.Viteza = vit;
		this.Pachete_actuale = vp;
		this.Nr_pachete = vp.size();
	}
	
	public void afisare() {
		super.afisare();
		System.out.println("Lungime: "+this.Lungime);
		System.out.println("Latime: "+this.Latime);
		System.out.println("Grosime: "+this.Grosime);
		System.out.println("Viteza: "+this.Viteza);
		System.out.println(this.Nr_pachete+" pachete");
		for(int i=0;i<Pachete_actuale.size();i++) {
			System.out.println("Pachet "+(i+1));
			Pachete_actuale.get(i).afisare();
		}
	}
	
	public void salvare(String numeFisier, File logFile) {

    	PrintWriter filePrint;
    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("Conveior: ");
    		super.salvare(numeFisier, logFile);
    		filePrint.println("      Lungime: " + this.Lungime);
    		filePrint.println("      Latime: " + this.Latime);
    		filePrint.println("      Grosime: " + this.Grosime);
    		filePrint.println("      Viteza: " + this.Viteza);
    		filePrint.println("      Numar pachete: " + this.Nr_pachete);
    		for(int i=0;i<Pachete_actuale.size();i++) {
    			filePrint.println("      Pachet "+(i+1));
    			Pachete_actuale.get(i).salvare(numeFisier, logFile);
    		}
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
	
	public void Adauga_pachet(Pachet pachet) {
		this.Pachete_actuale.add(pachet);
		this.Nr_pachete++;
	}
	
	public void Elimina_pachet(int id) {
		Pachete_actuale.removeIf(pachet-> pachet.GetID() == id);
		this.Nr_pachete--;
	}
	
	public int GetNrPachete()
	{
		return this.Nr_pachete;
	}
	
	public Pachet GetPachet(int id) {
		for(int i = 0; i < this.Nr_pachete; i++)
			if(Pachete_actuale.get(i).GetID() == id)
				return Pachete_actuale.get(i);
		
		Pachet p = new Pachet();
		return p;
	}
	
}
