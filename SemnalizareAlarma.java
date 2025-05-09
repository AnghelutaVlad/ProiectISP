package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Ambalare.BratRobotic;
import Ambalare.Conveior;
import Ambalare.Pachet;
import Ambalare.Robot;
import Ambalare.RobotMobil;
import Ambalare.Segment_brat;
import Ambalare.SistemMonitorizare;
import Ambalare.StareRobot;
import Ambalare.Supervizor;
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
		
		Supervizor sup = new Supervizor();
		
		b.SetStare(StareRobot.Defect);

		ArrayList<Robot> roboti = new ArrayList<Robot>();
		ArrayList<Integer> id_defecte = new ArrayList<Integer>();
		roboti.add(rm);
		roboti.add(b);
		roboti.add(c);
		
		for(int i = 0; i<roboti.size();i++) {
			int r = sistem.DiagnosticRobot(roboti.get(i));
			if(r!=-1) {
				id_defecte.add(r);
			}
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Brat_defect);
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					sup.interventie(roboti.get(i));
				}
			}
		}
		
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					assertEquals(roboti.get(i).GetStare(),StareRobot.In_mentenanta);
				}
			}
		}
		if(id_defecte.size()>0) {
			sup.revalidareSistem(roboti, sistem);
		}
		
		assertEquals(sistem.GetAlarma(),TipAlarma.Functionare_normala);
		
	}
	
	@Test
	void RobotMobilDefect() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		Supervizor sup = new Supervizor();
		rm.SetStare(StareRobot.Defect);
		
		ArrayList<Robot> roboti = new ArrayList<Robot>();
		ArrayList<Integer> id_defecte = new ArrayList<Integer>();
		roboti.add(rm);
		roboti.add(b);
		roboti.add(c);
		
		for(int i = 0; i<roboti.size();i++) {
			int r = sistem.DiagnosticRobot(roboti.get(i));
			if(r!=-1) {
				id_defecte.add(r);
			}
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Robot_mobil_defect);
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					sup.interventie(roboti.get(i));
				}
			}
		}
		
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					assertEquals(roboti.get(i).GetStare(),StareRobot.In_mentenanta);
				}
			}
		}
		
		if(id_defecte.size()>0) {
			sup.revalidareSistem(roboti, sistem);
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Functionare_normala);
		
	}
	@Test
	void ConveiorDefect() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		Supervizor sup = new Supervizor();
		c.SetStare(StareRobot.Defect);
		
		ArrayList<Robot> roboti = new ArrayList<Robot>();
		ArrayList<Integer> id_defecte = new ArrayList<Integer>();
		roboti.add(rm);
		roboti.add(b);
		roboti.add(c);
		
		for(int i = 0; i<roboti.size();i++) {
			int r = sistem.DiagnosticRobot(roboti.get(i));
			if(r!=-1) {
				id_defecte.add(r);
			}
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Conveior_defect);
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					sup.interventie(roboti.get(i));
				}
			}
		}
		
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					assertEquals(roboti.get(i).GetStare(),StareRobot.In_mentenanta);
				}
			}
		}
		
		if(id_defecte.size()>0) {
			sup.revalidareSistem(roboti, sistem);
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Functionare_normala);
		
	}
	@Test
	void Normal() {
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		Supervizor sup = new Supervizor();
		
		ArrayList<Robot> roboti = new ArrayList<Robot>();
		ArrayList<Integer> id_defecte = new ArrayList<Integer>();
		roboti.add(rm);
		roboti.add(b);
		roboti.add(c);
		
		for(int i = 0; i<roboti.size();i++) {
			int r = sistem.DiagnosticRobot(roboti.get(i));
			if(r!=-1) {
				id_defecte.add(r);
			}
		}
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					sup.interventie(roboti.get(i));
				}
			}
		}
		
		for(int i = 0;i<roboti.size();i++) {
			for(int j = 0;j<id_defecte.size();j++) {
				if(id_defecte.get(j)==roboti.get(i).GetID()) {
					assertEquals(roboti.get(i).GetStare(),StareRobot.In_mentenanta);
				}
			}
		}
		
		
		if(id_defecte.size()>0) {
			sup.revalidareSistem(roboti, sistem);
		}
		assertEquals(sistem.GetAlarma(),TipAlarma.Functionare_normala);
		
	}

}
