package Ambalare;

import java.time.LocalDate;

public class Aplicatie {
	public static void main(String[] args) {
		Segment_brat s = new Segment_brat(4,5,true);
		//s.afisare();
		
		SistemMonitorizare m = new SistemMonitorizare();
		RobotMobil r = new RobotMobil(2,LocalDate.now(),2,StareRobot.Defect,LocalDate.now(),2,2,2,2,2);
		
		System.out.println(m.DiagnosticRobot(r));
		System.out.println(m.GetAlarma());
		
	}
}
