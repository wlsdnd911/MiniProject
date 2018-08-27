package com.jplayer.gui.frame;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;

class JFrameEx2 extends JFrame{
	
	private JPanel panel =new JPanel(); 
	
	private JLabel albumIcon = new JLabel("AlbumIcon");
	
	private JButton playButton = new JButton("Play");
	private JButton pauseButton = new JButton("Pause");
	private JButton stopButton = new JButton("Stop");
	private JButton nextButton = new JButton("Next");
	private JButton previousButton = new JButton("Previous");
	
	private JSlider playtimeSlider = new JSlider();
	
	private JButton sound = new JButton("sound");
	private JButton lyrics = new JButton("lyrics");
	
	private JLabel list = new JLabel("Playlist");
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menu = new JMenu("Menu");
	private JMenuItem file = new JMenuItem("Open file");
	private JMenuItem folder = new JMenuItem("Open folder");
	private JMenuItem exit = new JMenuItem("Exit");
	
	private JMenu playback = new JMenu("Playback");
	private JMenuItem play = new JMenuItem("Play");	
	private JMenuItem pause = new JMenuItem("Pause");
	private JMenuItem stop = new JMenuItem("Stop");
	private JMenuItem next = new JMenuItem("Next");
	private JMenuItem previous = new JMenuItem("Previous");
			
	private JMenu edit = new JMenu("Edit");
	private JMenuItem color = new JMenuItem("Color");
	
	private JMenu help = new JMenu("Help");
	private JMenuItem info = new JMenuItem("Developer Information");
	
//	화면 처리 기능
	public void display() {
		this.setContentPane(panel);
		panel.setLayout(null);	
		
		albumIcon.setBounds(10, 10, 40, 40);
		panel.add(albumIcon);
		
		stopButton.setBounds(60, 10, 40, 40);
		panel.add(stopButton);
		
		playButton.setBounds(110, 10, 40, 40);
		panel.add(playButton);
		
		previousButton.setBounds(160, 10, 40, 40);
		panel.add(previousButton);
		
		pauseButton.setBounds(210, 10, 40, 40);
		panel.add(pauseButton);
		
		nextButton.setBounds(260, 10, 40, 40);
		panel.add(nextButton);
		
		playtimeSlider.setBounds(500, 10, 350, 40);
		panel.add(playtimeSlider);
		
		sound.setBounds(860, 10, 40, 40);
		panel.add(sound);
		
		lyrics.setBounds(910, 10, 40, 40);
		panel.add(lyrics);
		
		list.setBounds(10, 60, 965, 470);
		panel.add(list);
		
	}
	
//	메뉴 구현 기능
	public void menu() {
		this.setJMenuBar(menuBar);
//		menuBar.setOpaque(true);
//		menuBar.setBackground(Color.PINK);
		
		menuBar.add(menu);
		menuBar.add(playback);
		menuBar.add(edit);
		menuBar.add(help);
		
		menu.add(file);
		menu.add(folder);
		menu.add(exit);
		
		playback.add(play);
		playback.add(pause);
		playback.add(stop);
		playback.add(next);
		playback.add(previous);
		
		edit.add(color);
		
		help.add(info);
	}
	
//	이벤트 처리 기능
	public void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
		info.addActionListener(e->{
			JOptionPane.showMessageDialog(panel, "Developer : SW-5 Team 4");
		});
	}

//	생성자
	JFrameEx2(){
		this.display();
		this.menu();
		this.event();
		
		this.setTitle("MP3 Player");
		this.setLocationByPlatform(true);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test02 {
	public static void main(String[] args) {
		JFrameEx2 frame2 = new JFrameEx2();
	
	}
}
