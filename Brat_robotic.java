package Vlad;

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
	
	public int GetRazaActiune() {
		int raza = 0;
		for(int i = 0; i < Segmente.size();i++) {
			raza += Segmente.get(i).getLungime();
		}
		return raza;
	}
	public void AmbalarePachet(Pachet p) {
		
	}
	public void SortareObiect(Pachet p) {
		
	}
	
}
