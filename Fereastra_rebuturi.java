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

public class Fereastra_rebuturi extends JFrame {
	
	int primul_conveior = 0;
	int preluat_robot_mobil = 0;
	
	JProgressBar bar_primul_conveior = new JProgressBar();
	JProgressBar bar_actiune_robot_mobil = new JProgressBar();
	
	JLabel label_primul_conveior = new JLabel("Progresul pachetului pe primul conveior");
	JLabel label_actiune_robot_mobil = new JLabel("Progresul robotului mobil pana la depozit");
	

	
	Fereastra_rebuturi()
	{

		
		bar_primul_conveior.setValue(0);
		bar_primul_conveior.setBounds(0,0,450,50);
		bar_primul_conveior.setStringPainted(true);
		bar_primul_conveior.setBackground(Color.black);

		
		bar_actiune_robot_mobil.setValue(0);
		bar_actiune_robot_mobil.setBounds(0,0,450,50);
		bar_actiune_robot_mobil.setStringPainted(true);
		bar_actiune_robot_mobil.setBackground(Color.black);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(4,1));
		this.setSize(500,500);
		this.setVisible(true);
		
		this.add(label_primul_conveior);
		this.add(bar_primul_conveior);
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
				bar_primul_conveior.setString("Pachetul a ajuns la robotul mobil");
				primul_conveior = 1;
				preluat_robot_mobil = 0;
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
				primul_conveior = 0;
				preluat_robot_mobil = 1;
			}
		};
		worker.execute();
	}
	

	public int GetPrimul_conveior() {
		return primul_conveior;
	}
	
	public int GetPreluat_Robot() {
		return preluat_robot_mobil;
	}
	
	
}