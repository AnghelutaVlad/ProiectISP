package Ambalare;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI extends JFrame implements ActionListener {

	JButton button_mic, button_mare, button_rebut, button_raport;
	ArrayList<RobotMobil> robotimobili;
	ArrayList<BratRobotic> braterobotice;
	ArrayList<Conveior> conveioare;
	SistemMonitorizare sis_mon;
	Supervizor sup;
	ArrayList<Pachet> pac_mari_dep;
	ArrayList<Pachet> pac_mici_dep;
	ArrayList<Pachet> reb_dep;
	String Fisier_raport;
	static int IDpac = 1;
	int ID_conv_intrare, ID_conv_mici, ID_conv_mari;
	
	GUI(ArrayList<RobotMobil> rm, ArrayList<BratRobotic> br, ArrayList<Conveior> c, SistemMonitorizare sm, ArrayList<Pachet> pac_m, ArrayList<Pachet> pac_M, ArrayList<Pachet> reb, int ID_cin, int ID_mari, int ID_mici, String file, Supervizor sp)
	{

		robotimobili = rm;
		braterobotice = br;
		conveioare = c;
		sis_mon = sm;
		sup = sp;
		pac_mici_dep = pac_m;
		pac_mari_dep = pac_M;
		reb_dep = reb;
		ID_conv_intrare = ID_cin;
		ID_conv_mici = ID_mici;
		ID_conv_mari = ID_mari;
		Fisier_raport = file;
		
		button_mic = new JButton();
		button_mare = new JButton();
		button_rebut = new JButton();
		button_raport = new JButton();
		
		button_mic.setBounds(200, 100, 100, 50);
		button_mic.addActionListener(this);
		button_mic.setText("Adauga pachet mic");
		button_mic.setFocusable(false);
		button_mic.setHorizontalTextPosition(JButton.CENTER);
		button_mic.setVerticalTextPosition(JButton.CENTER);
		
		button_mare.setBounds(200, 100, 100, 50);
		button_mare.addActionListener(this);
		button_mare.setText("Adauga pachet mare");
		button_mare.setFocusable(false);
		button_mare.setHorizontalTextPosition(JButton.CENTER);
		button_mare.setVerticalTextPosition(JButton.CENTER);
		
		button_rebut.setBounds(200, 100, 100, 50);
		button_rebut.addActionListener(this);
		button_rebut.setText("Adauga pachet rebut");
		button_rebut.setFocusable(false);
		button_rebut.setHorizontalTextPosition(JButton.CENTER);
		button_rebut.setVerticalTextPosition(JButton.CENTER);
		
		button_raport.setBounds(200, 100, 100, 50);
		button_raport.addActionListener(this);
		button_raport.setText("Salveaza raport");
		button_raport.setFocusable(false);
		button_raport.setHorizontalTextPosition(JButton.CENTER);
		button_raport.setVerticalTextPosition(JButton.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,1));
		this.setSize(500,500);
		this.setVisible(true);
		
		this.add(button_mic);
		this.add(button_mare);
		this.add(button_rebut);
		this.add(button_raport);
	}
	
	public void interventie_supervizor()
	{
		JOptionPane.showMessageDialog(null, "A fost identificat un robot defect. S-a setat alarma: " + sis_mon.GetAlarma(), "Alarma", JOptionPane.WARNING_MESSAGE);
		
		switch(sis_mon.GetAlarma())
		{
		case TipAlarma.Brat_defect:
			for(int i = 0; i < braterobotice.size(); i++)
				if(braterobotice.get(i).GetStare() == StareRobot.Defect)
					sup.interventie(braterobotice.get(i));
				else
					braterobotice.get(i).SetStare(StareRobot.Inactiv);
			break;
		case TipAlarma.Conveior_defect:
			for(int i = 0; i < conveioare.size(); i++)
				if(conveioare.get(i).GetStare() == StareRobot.Defect)
					sup.interventie(conveioare.get(i));
				else
					conveioare.get(i).SetStare(StareRobot.Inactiv);
			break;
		case TipAlarma.Robot_mobil_defect:
			for(int i = 0; i < robotimobili.size(); i++)
				if(robotimobili.get(i).GetStare() == StareRobot.Defect)
					sup.interventie(robotimobili.get(i));
				else
					robotimobili.get(i).SetStare(StareRobot.Inactiv);
			break;
		}
		
		int wait = 0;
		while (wait < 100)
		{   try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			wait++;
		}
		
		sup.revalidareSistem(braterobotice);
		sup.revalidareSistem(conveioare);
		sup.revalidareSistem(robotimobili);
		
		sis_mon.SetAlarma(TipAlarma.Functionare_normala);
		
		JOptionPane.showMessageDialog(null, "Sistemul a fost revalidat. Acesta este acum in starea: " + sis_mon.GetAlarma(), "Alarma", JOptionPane.INFORMATION_MESSAGE);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_mic) {
			Random rand = new Random();
			int pos_in = 0;
			Pachet p = new Pachet(rand.nextInt(Constante.Greutate_Max - Constante.Greutate_Min + 1) + Constante.Greutate_Min, rand.nextInt(1)+2, rand.nextInt(3)+3, IDpac);
			IDpac++;
			p.SetTip(sis_mon.IdentificareCategorie(p));
			p.SetStare(sis_mon.DiagnosticPachet(p));
			p.afisare();
			ArrayList<Pachet> vp = new ArrayList<Pachet>();
			vp.add(p);
			
			for(int i = 0; i < conveioare.size(); i++)
				if(conveioare.get(i).GetID() == ID_conv_intrare)
					{ pos_in = i;
					  conveioare.get(i).DeplasareObiecte();
					  sis_mon.DiagnosticRobot(conveioare.get(i));
					  sis_mon.TrimisComanda(braterobotice.get(0), conveioare.get(i), vp);
					  sis_mon.DiagnosticRobot(braterobotice.get(0));
					  break;
					}

			if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
				interventie_supervizor();
			JOptionPane.showMessageDialog(null, "Pachetul a fost pus pe primul conveior" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
			int wait = 0;
			while (wait < 100)
			{   try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				wait++;
			}

			if(p.GetStare() == StarePachet.Valid)
			switch(p.GetTip()) {
			case TipPachet.Mic:
				int pos_c = 0;
				for(int i = 0; i < conveioare.size(); i++)
					if(conveioare.get(i).GetID() == ID_conv_mici)
						{ conveioare.get(i).DeplasareObiecte();
						  sis_mon.DiagnosticRobot(conveioare.get(i));
						  sis_mon.TrimisComanda(braterobotice.get(1), p, conveioare.get(pos_in), conveioare.get(i));	
						  sis_mon.DiagnosticRobot(braterobotice.get(1));
						  pos_c = i;
						  break;
						}
				
				if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
					interventie_supervizor();
				JOptionPane.showMessageDialog(null, "Pachetul a fost sortat pe conveiorul corespunzator" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				wait = 0;
				while (wait < 100)
				{   try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					wait++;
				}
				
				for(int i = 0; i < robotimobili.size(); i++)
					if(robotimobili.get(i).GetStare() == StareRobot.Inactiv) {
						conveioare.get(pos_c).Elimina_pachet(p.GetID());
						sis_mon.TrimisComanda(robotimobili.get(i), p, pac_mici_dep);
						sis_mon.DiagnosticRobot(robotimobili.get(i));
					}

				if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
					interventie_supervizor();
				JOptionPane.showMessageDialog(null, "Pachetul a fost preluat de un robot mobil" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				wait = 0;
				while (wait < 100)
				{   try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					wait++;
				}
				
				JOptionPane.showMessageDialog(null, "Pachetul a ajuns in depozit" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				break;
				
			default:
				System.out.print("Pachetul nu era mic");
			}
			
			else
				System.out.print("Pachetul nu era valid");
		}
		if (e.getSource() == button_mare) {
			Random rand = new Random();
			int pos_in = 0;
			Pachet p = new Pachet(rand.nextInt(Constante.Greutate_Max - Constante.Greutate_Min + 1) + Constante.Greutate_Min, rand.nextInt(1)+2, rand.nextInt(1)+6, IDpac);
			IDpac++;
			p.SetTip(sis_mon.IdentificareCategorie(p));
			p.SetStare(sis_mon.DiagnosticPachet(p));
			p.afisare();
			ArrayList<Pachet> vp = new ArrayList<Pachet>();
			vp.add(p);
			
			for(int i = 0; i < conveioare.size(); i++)
				if(conveioare.get(i).GetID() == ID_conv_intrare)
					{ pos_in = i;
					  conveioare.get(i).DeplasareObiecte();
					  sis_mon.DiagnosticRobot(conveioare.get(i));
					  sis_mon.TrimisComanda(braterobotice.get(0), conveioare.get(i), vp);	
					  sis_mon.DiagnosticRobot(braterobotice.get(0));
					  break;
					}
			
			if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
				interventie_supervizor();
			JOptionPane.showMessageDialog(null, "Pachetul a fost pus pe primul conveior" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
			int wait = 0;
			while (wait < 100)
			{   try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				wait++;
			}
			if (p.GetStare() == StarePachet.Valid)
			switch(p.GetTip()) {
			case TipPachet.Mare:
				int pos_c = 0;
				for(int i = 0; i < conveioare.size(); i++)
					if(conveioare.get(i).GetID() == ID_conv_mari)
						{ conveioare.get(i).DeplasareObiecte();
						  sis_mon.DiagnosticRobot(conveioare.get(i));
						  sis_mon.TrimisComanda(braterobotice.get(1), p, conveioare.get(pos_in), conveioare.get(i));	
						  sis_mon.DiagnosticRobot(braterobotice.get(1));
						  pos_c = i;
						  break;
						}
				
				if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
					interventie_supervizor();
				JOptionPane.showMessageDialog(null, "Pachetul a fost sortat pe conveiorul corespunzator" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				wait = 0;
				while (wait < 100)
				{   try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					wait++;
				}
				
				for(int i = 0; i < robotimobili.size(); i++)
					if(robotimobili.get(i).GetStare() == StareRobot.Inactiv) {
						conveioare.get(pos_c).Elimina_pachet(p.GetID());
						sis_mon.TrimisComanda(robotimobili.get(i), p, pac_mari_dep);
						sis_mon.DiagnosticRobot(robotimobili.get(i));
					}
				
				if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
					interventie_supervizor();
				JOptionPane.showMessageDialog(null, "Pachetul a fost preluat de un robot mobil" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				wait = 0;
				while (wait < 100)
				{   try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					wait++;
				}
				
				JOptionPane.showMessageDialog(null, "Pachetul a ajuns in depozit" , "Pachet", JOptionPane.PLAIN_MESSAGE);	
				break;
				
			default:
				System.out.print("Pachetul nu era mare");
			}
			
			else
				System.out.print("Pachetul nu era valid");
			
		}
		if (e.getSource() == button_rebut) {
			Random rand = new Random();
			int pos_in = 0;
			Pachet p = new Pachet(rand.nextInt(Constante.Greutate_Max - Constante.Greutate_Min + 1) + Constante.Greutate_Min, rand.nextInt(3)+3, rand.nextInt(3)+6, IDpac);
			IDpac++;
			p.SetTip(sis_mon.IdentificareCategorie(p));
			p.SetStare(sis_mon.DiagnosticPachet(p));
			p.afisare();
			ArrayList<Pachet> vp = new ArrayList<Pachet>();
			vp.add(p);
			
			for(int i = 0; i < conveioare.size(); i++)
				if(conveioare.get(i).GetID() == ID_conv_intrare)
					{ pos_in = i;
					  conveioare.get(i).DeplasareObiecte();
					  sis_mon.DiagnosticRobot(conveioare.get(i));
					  sis_mon.TrimisComanda(braterobotice.get(0), conveioare.get(i), vp);	
					  sis_mon.DiagnosticRobot(braterobotice.get(0));
					  break;
					}
			
			if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
				interventie_supervizor();
			JOptionPane.showMessageDialog(null, "Rebutul a fost pus pe primul conveior" , "Rebut", JOptionPane.PLAIN_MESSAGE);	
			int wait = 0;
			while (wait < 100)
			{   try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				wait++;
			}
			
			if(p.GetStare() == StarePachet.Rebut)	
				{for(int i = 0; i < robotimobili.size(); i++)
					if(robotimobili.get(i).GetStare() == StareRobot.Inactiv) {
						conveioare.get(pos_in).Elimina_pachet(p.GetID());
						sis_mon.TrimisComanda(robotimobili.get(i), p, reb_dep);
						sis_mon.DiagnosticRobot(robotimobili.get(i));
					}
				
				if(sis_mon.GetAlarma() != TipAlarma.Functionare_normala)
					interventie_supervizor();
				JOptionPane.showMessageDialog(null, "Rebutul a fost preluat de un robot mobil" , "Rebut", JOptionPane.PLAIN_MESSAGE);	
				wait = 0;
				while (wait < 100)
				{   try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					wait++;
				}
				
				
				JOptionPane.showMessageDialog(null, "Rebutul a ajuns in zona de decartare" , "Rebut", JOptionPane.PLAIN_MESSAGE);	
				
				}
				
			else
				System.out.print("Pachetul nu era rebut");
			}
		
		if (e.getSource() == button_raport) {
			
			LocalDateTime data_azi = LocalDateTime.now(); 
			DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd_mm_yyyy_HH_mm_ss");
			
			
			String data_formatata = data_azi.format(frm);
			String Nume_fisier = Fisier_raport + data_formatata + ".txt";
			
			File logFile = new File(Nume_fisier);
	    	try {
	    		logFile.createNewFile();
	    	} catch(IOException e1) {
	    		e1.printStackTrace();
	    	}
			sis_mon.salvare(Fisier_raport, logFile);
			sup.salvare(Fisier_raport, logFile);
			for(int i = 0; i < conveioare.size(); i++)
				conveioare.get(i).salvare(Fisier_raport, logFile);
			for(int i = 0; i < braterobotice.size(); i++)
				braterobotice.get(i).salvare(Fisier_raport, logFile);
			for(int i = 0; i < robotimobili.size(); i++)
				robotimobili.get(i).salvare(Fisier_raport, logFile);
			for(int i = 0; i < pac_mari_dep.size(); i++)
				pac_mari_dep.get(i).salvare(Fisier_raport, logFile);
			for(int i = 0; i < pac_mici_dep.size(); i++)
				pac_mici_dep.get(i).salvare(Fisier_raport, logFile);
			for(int i = 0; i < reb_dep.size(); i++)
				reb_dep.get(i).salvare(Fisier_raport, logFile);
		}
		}
		
	}
