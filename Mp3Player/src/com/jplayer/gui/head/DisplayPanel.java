package com.jplayer.gui.head;

import java.awt.Color;

import javax.swing.*;

public class DisplayPanel extends JPanel {
	
	private JLabel album = new JLabel("Album", JLabel.CENTER);
	private JButton playButton = new JButton("¢¹");
	private JButton pauseButton = new JButton("||");
	private JButton stopButton = new JButton("¡à");
	private JButton nextButton = new JButton("¢¹||");
	private JButton prevButton = new JButton("||¢·");
	private JLabel info = new JLabel("Music info");
	
	public DisplayPanel() {
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		album.setBounds(0, 0, 50, 50);
		this.add(album);
		
		stopButton.setBounds(50, 0, 50, 50);
		this.add(stopButton);
		
		playButton.setBounds(100, 0, 50, 50);
		this.add(playButton);
		
		prevButton.setBounds(150, 0, 50, 50);
		this.add(prevButton);
		
		pauseButton.setBounds(200, 0, 50, 50);
		this.add(pauseButton);
		
		nextButton.setBounds(250, 0, 50, 50);
		this.add(nextButton);
		
		info.setBounds(300, 0, 193, 50);
		this.add(info);
		
	}

	public JLabel getAlbum() {
		return album;
	}

	public JButton getStopButton() {
		return stopButton;
	}
	
	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getPrevButton() {
		return prevButton;
	}
	
	public JButton getPauseButton() {
		return pauseButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public JLabel getInfo() {
		return info;
	}
	
}
