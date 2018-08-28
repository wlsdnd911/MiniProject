package com.jplayer.gui.frame;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class MainFrame extends JFrame implements ActionListener{
	
	private JPanel panel =new JPanel(); 
	
	private JLabel albumIcon = new JLabel("AlbumIcon", JLabel.CENTER);
	
	private JButton playButton = new JButton("Play");
	private JButton pauseButton = new JButton("Pause");
	private JButton stopButton = new JButton("Stop");
	private JButton nextButton = new JButton("Next");
	private JButton previousButton = new JButton("Previous");   
	
	private JTextField pathName = new JTextField("Path name");
	
	private JSlider playtimeSlider = new JSlider();
	
	private JButton sound = new JButton("sound");
	private JButton lyrics = new JButton("lyrics");
	
	private JLabel list = new JLabel("Playlist", JLabel.CENTER);
	
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

	private File musicFile;
	private FileInputStream input;
	
	private Player player;
	private Thread playThread;
	
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
		
		pathName.setBounds(310, 10, 285, 40);
		panel.add(pathName);
		
		playtimeSlider.setBounds(595, 10, 285, 40);
		panel.add(playtimeSlider);
		
		sound.setBounds(880, 10, 40, 40);
		panel.add(sound);
		
		lyrics.setBounds(930, 10, 40, 40);
		panel.add(lyrics);
		
		list.setBounds(10, 60, 965, 470);
		panel.add(list);
	}
	
//	메뉴 구현 기능
	public void menu() {
		this.setJMenuBar(menuBar);
		
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
		this.addActionListener();
	}
	
	public void addActionListener() {
		
		file.addActionListener(this);
		
		play.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);
		next.addActionListener(this);
		previous.addActionListener(this);
		
		stopButton.addActionListener(this);
		playButton.addActionListener(this);
		nextButton.addActionListener(this);
		pauseButton.addActionListener(this);
		previousButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == file) {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select a file you wish to play..");
			chooser.showOpenDialog(file);
			
			String fileName = chooser.getSelectedFile().getName();
			String filePath = chooser.getSelectedFile().getPath();
			
			musicFile = new File(filePath);
			try {
				input = new FileInputStream(musicFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == play) {
			playThread.start();
			
		}
		
		if(e.getSource() == stop) {
			if(player != null) {
				player.close();
			}
		}
		
		Runnable runnablePlay = new Runnable() {
			public void run() {
				try {
					player = new Player(input);
					player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}			
		};
	}

//	생성자
	public MainFrame() {
		this.display();
		this.menu();
		this.event();
		
		this.setTitle("MP3 Player");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
