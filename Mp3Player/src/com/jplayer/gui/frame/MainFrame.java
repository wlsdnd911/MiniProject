package com.jplayer.gui.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.jplayer.gui.body.InitialPanel;
import com.jplayer.gui.head.DisplayPanel;
import com.jplayer.gui.head.SliderPanel;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private DisplayPanel dp;
	private SliderPanel sp;
	
//	ȭ�� ó�� ���
	public void display() {
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		dp = new DisplayPanel();
		mainPanel.add(dp); 
		dp.setBounds(0, 0, 493, 50);
		
		sp = new SliderPanel();
		mainPanel.add(sp);
		sp.setBounds(493, 0, 493, 50);
		
		mainPanel.add(southPanel);
		southPanel.setBounds(0, 50, 986, 515);
		southPanel.setLayout(null);
		southPanel.setBackground(Color.GRAY);	
		
	}
	
//	�޴� ���� ���
	public void menu() {

	}
	
//	�̺�Ʈ ó�� ���
	public void event() {

	}

//	������
	public MainFrame() {
		this.display();
		this.menu();
		this.event();
		
		this.setTitle("MP3 Player");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
