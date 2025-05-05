package Vlad;

import java.time.LocalDate;

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
	public void SetStare(StareRobot s) {
		this.Stare = s;
	}
	public StareRobot GetStare() {
		return Stare;
	}
	public void DeplasareObiecte() {
		this.Stare = StareRobot.Activ;
	}
	public int GetCapacitate() {
		return Capacitate;
	}
	
}
