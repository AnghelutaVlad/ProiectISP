package Ambalare;

import java.time.LocalDate;
import java.util.ArrayList;


public class Aplicatie {
	public static void main(String[] args) {
//		Segment_brat s = new Segment_brat(4,5,true);
//		s.afisare();
//		
		ArrayList<RobotMobil> lista_robotimobili = new ArrayList<RobotMobil>();
		ArrayList<BratRobotic> lista_braterobotice = new ArrayList<BratRobotic>();
		ArrayList<Conveior> lista_conveioare = new ArrayList<Conveior>();

		ArrayList<Pachet> pachete_mici_depozitate = new ArrayList<Pachet>();
		ArrayList<Pachet> pachete_mari_depozitate = new ArrayList<Pachet>();
		ArrayList<Pachet> rebuturi_depozitate = new ArrayList<Pachet>();
		
		SistemMonitorizare sistem_monitorizare = new SistemMonitorizare(20, "Nikon", LocalDate.of(2025, 1,23), TipAlarma.Functionare_normala);
		
		Supervizor angajat = new Supervizor("Nechifor", "Toma", 36, "1090789842709", 7500, LocalDate.of(2024, 11, 13));
		
		RobotMobil mob = new RobotMobil(1,LocalDate.now(),2,StareRobot.Inactiv,LocalDate.now(),2,2,2,2,2);
		
		ArrayList<Pachet> pachete_intrare = new ArrayList<Pachet>();
		ArrayList<Pachet> pachete_mari = new ArrayList<Pachet>();
		ArrayList<Pachet> pachete_mici = new ArrayList<Pachet>();
		Conveior c_intrare = new Conveior(1,LocalDate.of(2025, 1,23), 100, StareRobot.Inactiv, LocalDate.of(2025, 1,24), 300, 30, 2, 1, 5, pachete_intrare );
		Conveior c_mici = new Conveior(2,LocalDate.of(2025, 1,23), 100, StareRobot.Inactiv, LocalDate.of(2025, 1,24), 300, 30, 2, 1, 5, pachete_mici );
		Conveior c_mari = new Conveior(3,LocalDate.of(2025, 1,23), 100, StareRobot.Inactiv, LocalDate.of(2025, 1,24), 300, 30, 2, 1, 5, pachete_mari );
		
		ArrayList<Segment_brat> vec_seg1 = new ArrayList<Segment_brat>();
		vec_seg1.add(new Segment_brat(3,2,false));
		vec_seg1.add(new Segment_brat(3,2,false));
		vec_seg1.add(new Segment_brat(1,2,true));
		ArrayList<Integer> vint1 = new ArrayList<Integer>();
		ArrayList<Segment_brat> vec_seg2 = new ArrayList<Segment_brat>();
		vec_seg2.add(new Segment_brat(3,2,false));
		vec_seg2.add(new Segment_brat(3,2,false));
		vec_seg2.add(new Segment_brat(1,2,true));
		ArrayList<Integer> vint2 = new ArrayList<Integer>();
		vint1.add(30);
		vint1.add(30);
		vint1.add(60);
		vint2.add(30);
		vint2.add(30);
		vint2.add(60);
		
		BratRobotic b1 = new BratRobotic(1,LocalDate.of(2025, 1,23), 150, StareRobot.Inactiv, LocalDate.of(2025, 1,24),100,vint1,vec_seg1);
		BratRobotic b2 = new BratRobotic(2,LocalDate.of(2025, 1,23), 150, StareRobot.Inactiv, LocalDate.of(2025, 1,24),100,vint2,vec_seg2);
		
		lista_robotimobili.add(mob);
		lista_braterobotice.add(b1);
		lista_braterobotice.add(b2);
		lista_conveioare.add(c_intrare);
		lista_conveioare.add(c_mici);
		lista_conveioare.add(c_mari);
		
		
		
		
		String Fisier_raport = "Raport_";
		
		GUI g = new GUI(lista_robotimobili, lista_braterobotice, lista_conveioare, sistem_monitorizare, pachete_mici_depozitate, pachete_mari_depozitate, rebuturi_depozitate, c_intrare.GetID(), c_mari.GetID(), c_mici.GetID(), Fisier_raport, angajat);
	}
}
