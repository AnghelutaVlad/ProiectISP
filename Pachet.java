package Ambalare;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pachet {
	int Greutate;
	StarePachet Stare;
	int Lungime;
	int Latime;
	TipPachet Tip;
	int ID;
	
	public int GetID() {
		return this.ID;
	}
	
	public Pachet(int gr, int lung, int lat,int id)
	{
		Greutate = gr;
		Lungime = lung;
		Latime = lat;
		Stare = StarePachet.Valid;
		this.ID = id;
	}
	
	public Pachet()
	{
		Greutate = 0;
		Lungime = 0;
		Latime = 0;
		Stare = StarePachet.Rebut;
		this.ID = 0;
	}
	
	public int GetGreutate()
	{
		return this.Greutate;
	}
	
	public StarePachet GetStare()
	{
		return this.Stare;
	}
	
	public TipPachet GetTip()
	{
		return this.Tip;
	}
	
	public void SetTip(TipPachet t)
	{
		this.Tip=t;
	}
	
	public void SetStare(StarePachet s)
	{
		Stare = s;
	}
	
	public int Volum()
	{
		return Lungime * Latime * Latime;
	}
	
	public void afisare()
	{
		System.out.println("Detalii Pachet:");
		System.out.print("ID: ");
		System.out.println(ID);
		System.out.print("Greutate: ");
		System.out.println(Greutate);
		System.out.print("Latime: ");
		System.out.println(Latime);
		System.out.print("Lungime: ");
		System.out.println(Lungime);
		System.out.print("Stare: ");
		System.out.println(Stare);
		System.out.print("Tip: ");
		System.out.println(Tip);
		
	}
	
	public void salvare(String numeFisier, File logFile) {

    	PrintWriter filePrint;

    	
    	FileWriter testWriter;
    	try {
    		testWriter = new FileWriter(logFile, true);
    		filePrint = new PrintWriter(testWriter, true);
    		filePrint.println("Pachet: ");
    		filePrint.println("      ID: " + this.ID);
    		filePrint.println("      Greutate: " + this.Greutate);
    		filePrint.println("      Latime: " + this.Latime);
    		filePrint.println("      Lungime: " + this.Lungime);
    		filePrint.println("      Stare: " + this.Stare);
    		filePrint.println("      Tip: " + this.Tip);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
