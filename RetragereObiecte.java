package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Ambalare.BratRobotic;
import Ambalare.Conveior;
import Ambalare.Pachet;
import Ambalare.Segment_brat;
import Ambalare.SistemMonitorizare;
import Ambalare.StareRobot;
import Ambalare.TipAlarma;
import Ambalare.TipPachet;

class RetragereObiecte {
	SistemMonitorizare sistem = new SistemMonitorizare(20,"Nikon",LocalDate.of(2025,1,23),TipAlarma.Functionare_normala);
	@Test
	void pachetMic() {
		ArrayList<Pachet> pac_depozit = new ArrayList<Pachet>();
		Pachet p = new Pachet(50,3,3,1);
		pac_depozit.add(p);
		ArrayList<Pachet> pac_intrare= new ArrayList<Pachet>();
		Conveior intrare = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_intrare);
		ArrayList<Pachet> pac_mici= new ArrayList<Pachet>();
		Conveior c_mic = new Conveior(2,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_mici);
		ArrayList<Pachet> pac_mari= new ArrayList<Pachet>();
		Conveior c_mare = new Conveior(3,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_mari);
		
		ArrayList<Segment_brat> vs1 = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint1 = new ArrayList<Integer>();
		BratRobotic b1 = new BratRobotic(4,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint1,vs1);
		
		ArrayList<Segment_brat> vs2 = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint2 = new ArrayList<Integer>();
		BratRobotic b2 = new BratRobotic(5,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint2,vs2);
		
		sistem.TrimisComanda(b1, intrare, pac_depozit);
		intrare.DeplasareObiecte();
		Pachet pac = intrare.GetPachet(1);
		switch(sistem.IdentificareCategorie(pac)) {
			case TipPachet.Mic:
				sistem.TrimisComanda(b2, pac, intrare, c_mic);
				break;
			case TipPachet.Mare:
				sistem.TrimisComanda(b2, pac, intrare, c_mare);
				break;				
		}
		assertEquals(c_mic.GetNrPachete(),1);
	}
	
	@Test
	void pachetMare() {
		ArrayList<Pachet> pac_depozit = new ArrayList<Pachet>();
		Pachet p = new Pachet(50,3,5,1);
		pac_depozit.add(p);
		ArrayList<Pachet> pac_intrare= new ArrayList<Pachet>();
		Conveior intrare = new Conveior(1,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_intrare);
		ArrayList<Pachet> pac_mici= new ArrayList<Pachet>();
		Conveior c_mic = new Conveior(2,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_mici);
		ArrayList<Pachet> pac_mari= new ArrayList<Pachet>();
		Conveior c_mare = new Conveior(3,LocalDate.of(2025,1,23),200,StareRobot.Inactiv,LocalDate.of(2026,1,23),300,30,2,1,5,pac_mari);
		
		ArrayList<Segment_brat> vs1 = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint1 = new ArrayList<Integer>();
		BratRobotic b1 = new BratRobotic(4,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint1,vs1);
		
		ArrayList<Segment_brat> vs2 = new ArrayList<Segment_brat>();
		ArrayList<Integer> vint2 = new ArrayList<Integer>();
		BratRobotic b2 = new BratRobotic(5,LocalDate.of(2025,1,23),150,StareRobot.Inactiv,LocalDate.of(2026,1,23),100,vint2,vs2);
		
		sistem.TrimisComanda(b1, intrare, pac_depozit);
		intrare.DeplasareObiecte();
		Pachet pac = intrare.GetPachet(1);
		switch(sistem.IdentificareCategorie(pac)) {
			case TipPachet.Mic:
				sistem.TrimisComanda(b2, pac, intrare, c_mic);
				break;
			case TipPachet.Mare:
				sistem.TrimisComanda(b2, pac, intrare, c_mare);
				break;				
		}
		assertEquals(c_mare.GetNrPachete(),1);
	}

}
