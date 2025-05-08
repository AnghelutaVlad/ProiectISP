package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Ambalare.BratRobotic;
import Ambalare.Conveior;
import Ambalare.Pachet;
import Ambalare.RobotMobil;
import Ambalare.Segment_brat;
import Ambalare.SistemMonitorizare;
import Ambalare.StareRobot;
import Ambalare.TipAlarma;

class SemnalizareAlarma {
	SistemMonitorizare sistem = new SistemMonitorizare(20,"Nikon",LocalDate.of(2025,1,23),TipAlarma.Functionare_normala);
	@Test
	void BratDefect() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		
		b.SetStare(StareRobot.Defect);
		
		StareRobot r1 = sistem.DiagnosticRobot(b);
		StareRobot r2 = sistem.DiagnosticRobot(rm);
		StareRobot r3 = sistem.DiagnosticRobot(c);
		
		assertEquals(sistem.GetAlarma(),TipAlarma.Brat_defect);
		
	}
	
	@Test
	void RobotMobilDefect() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		
		rm.SetStare(StareRobot.Defect);
		
		StareRobot r1 = sistem.DiagnosticRobot(b);
		StareRobot r2 = sistem.DiagnosticRobot(rm);
		StareRobot r3 = sistem.DiagnosticRobot(c);
		
		assertEquals(sistem.GetAlarma(),TipAlarma.Robot_mobil_defect);
		
	}
	@Test
	void ConveiorDefect() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		
		c.SetStare(StareRobot.Defect);
		
		StareRobot r1 = sistem.DiagnosticRobot(b);
		StareRobot r2 = sistem.DiagnosticRobot(rm);
		StareRobot r3 = sistem.DiagnosticRobot(c);
		
		assertEquals(sistem.GetAlarma(),TipAlarma.Conveior_defect);
		
	}
	@Test
	void Normal() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		
		
		StareRobot r1 = sistem.DiagnosticRobot(b);
		StareRobot r2 = sistem.DiagnosticRobot(rm);
		StareRobot r3 = sistem.DiagnosticRobot(c);
		
		assertEquals(sistem.GetAlarma(),TipAlarma.Functionare_normala);
		
	}

}
