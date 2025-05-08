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
import Ambalare.StarePachet;
import Ambalare.StareRobot;
import Ambalare.TipAlarma;

class RetragereProdusDefect {
	SistemMonitorizare sistem = new SistemMonitorizare(20,"Nikon",LocalDate.of(2025,1,23),TipAlarma.Functionare_normala);
	@Test
	void testPachetNormal() {
		Pachet p = new Pachet(20,5,3,1);
		assertEquals(sistem.DiagnosticPachet(p),StarePachet.Valid);
	}
	
	@Test
	void BratOcupat() {
		Pachet p = new Pachet(20,5,5,2);
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Pachet> rebuturi = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		if(sistem.DiagnosticPachet(p)==StarePachet.Rebut) {
			sistem.TrimisComanda(c);
			c.Adauga_pachet(p);
			b.SetStare(StareRobot.Activ);
			if(b.GetStare()==StareRobot.Inactiv) {
				b.DeplasareObiecte();
				c.Elimina_pachet(2);
				sistem.TrimisComanda(b, p, rm, rebuturi);
			}
		}
		assertEquals(rebuturi.size(),0);
	}
	
	@Test
	void BratLiber() {
		Pachet p = new Pachet(20,5,5,2);
		ArrayList<Pachet> pac_conv = new ArrayList<Pachet>();
		ArrayList<Pachet> rebuturi = new ArrayList<Pachet>();
		ArrayList<Segment_brat> vs = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint = new ArrayList<Integer>();
		BratRobotic b = new BratRobotic(2,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint,vs);
		Conveior c = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_conv);
		RobotMobil rm = new RobotMobil(3,LocalDate.of(2025,1,23),60,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,1,1,1,10);
		if(sistem.DiagnosticPachet(p)==StarePachet.Rebut) {
			sistem.TrimisComanda(c);
			c.Adauga_pachet(p);
			if(b.GetStare()==StareRobot.Inactiv) {
				b.DeplasareObiecte();
				c.Elimina_pachet(2);
				sistem.TrimisComanda(b, p, rm, rebuturi);
			}
		}
		assertEquals(rebuturi.size(),1);
	}

	

}
