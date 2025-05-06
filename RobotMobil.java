package Ambalare;

import java.time.LocalDate;
import java.util.ArrayList;

public class RobotMobil extends Robot{
	private int Lungime;
	private int Latime;
	private int Inaltime;
	private int Viteza;
	
	public RobotMobil(int id, LocalDate ach, int g,StareRobot st,LocalDate rev, int c,int lun, int lat, int in, int vit) {
		super(id,ach,g,st,rev,c);
		this.Lungime = lun;
		this.Latime = lat;
		this.Inaltime = in;
		this.Viteza = vit;
	}
	
	public void afisare() {
		super.afisare();
		System.out.println("Lungime: "+this.Lungime);
		System.out.println("Latime: "+this.Latime);
		System.out.println("Inaltime: "+this.Inaltime);
		System.out.println("Viteza: "+this.Viteza);
	}
	public void DepozitarePachet(Pachet p, ArrayList<Pachet> vp) {
		vp.add(p);
	}
	public void RetragereProdusDefect(Pachet p, ArrayList<Pachet> vr) {
		vr.add(p);
	}
}
