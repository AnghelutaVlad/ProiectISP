package Ambalare;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
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
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import java.util.concurrent.CountDownLatch;

import java.util.List;

public class Fereastra_pachete_mici extends JFrame {
	
	int primul_conveior = 0;
	int al_doilea_conveior = 0;
	int preluat_robot_mobil = 0;
	int stocat_depozit = 0;
	
	JProgressBar bar_primul_conveior = new JProgressBar();
	JProgressBar bar_al_doilea_conveior = new JProgressBar();
	JProgressBar bar_actiune_robot_mobil = new JProgressBar();
	
	JLabel label_primul_conveior = new JLabel("Progresul pachetului pe primul conveior");
	JLabel label_al_doilea_conveior = new JLabel("Progresul pachetului pe al doilea conveior");
	JLabel label_actiune_robot_mobil = new JLabel("Progresul robotului mobil pana la depozit");
	

	
	Fereastra_pachete_mici()
	{

		
		bar_primul_conveior.setValue(0);
		bar_primul_conveior.setBounds(0,0,450,50);
		bar_primul_conveior.setStringPainted(true);
		bar_primul_conveior.setBackground(Color.black);
		
		bar_al_doilea_conveior.setValue(0);
		bar_al_doilea_conveior.setBounds(0,0,450,50);
		bar_al_doilea_conveior.setStringPainted(true);
		bar_al_doilea_conveior.setBackground(Color.black);
		
		bar_actiune_robot_mobil.setValue(0);
		bar_actiune_robot_mobil.setBounds(0,0,450,50);
		bar_actiune_robot_mobil.setStringPainted(true);
		bar_actiune_robot_mobil.setBackground(Color.black);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(6,1));
		this.setSize(500,500);
		this.setVisible(true);
		
		this.add(label_primul_conveior);
		this.add(bar_primul_conveior);
		this.add(label_al_doilea_conveior);
		this.add(bar_al_doilea_conveior);
		this.add(label_actiune_robot_mobil);
		this.add(bar_actiune_robot_mobil);
		
		
	}
	
	public void fill_primul_conveior() {
		
		SwingWorker<Void, Integer> worker = new SwingWorker<>() {
			
			@Override
			protected Void doInBackground() throws Exception{
				for(int i = 0; i <=100; i++) {
					Thread.sleep(20);
					publish(i);
				}
				return null;
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				int value = chunks.get(chunks.size() - 1);
				bar_primul_conveior.setValue(value);
			}
			
			@Override
			protected void done() {
				bar_primul_conveior.setString("Pachetul a ajuns la bratul robotic");

			}
		};
		
		worker.execute();
	}
	
	public void fill_al_doilea_conveior() {
		SwingWorker<Void, Integer> worker = new SwingWorker<>() {
			
			@Override
			protected Void doInBackground() throws Exception{
				for(int i = 0; i <=100; i++) {
					Thread.sleep(20);
					publish(i);
				}
				return null;
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				int value = chunks.get(chunks.size() - 1);
				bar_al_doilea_conveior.setValue(value);
			}
			
			@Override
			protected void done() {
				bar_al_doilea_conveior.setString("Pachetul a ajuns la robotul mobil");

			}
		};
		
		worker.execute();

	}
	
	public void fill_actiune_robot_mobil() {
		SwingWorker<Void, Integer> worker = new SwingWorker<>() {
			
			@Override
			protected Void doInBackground() throws Exception{
				for(int i = 0; i <=100; i++) {
					Thread.sleep(20);
					publish(i);
				}
				return null;
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				int value = chunks.get(chunks.size() - 1);
				bar_actiune_robot_mobil.setValue(value);
			}
			
			@Override
			protected void done() {
				bar_actiune_robot_mobil.setString("Robotul mobil a livrat pachetul");

			}
		};
		worker.execute();
	}
	

}