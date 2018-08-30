package com.jplayer.gui.head;

import java.awt.Color;

import javax.swing.*;

public class SliderPanel extends JPanel {
	
	private JSlider playtimeSlider = new JSlider();
	private JButton sound = new JButton("sound");
	private JButton lyrics = new JButton("lyrics");
	
	public SliderPanel() {
		this.setBackground(Color.PINK);
		this.setLayout(null);
		
		playtimeSlider.setBounds(0, 0, 386, 50);
		this.add(playtimeSlider);
		
		sound.setBounds(386, 0, 50, 50);
		this.add(sound);
		
		lyrics.setBounds(436, 1, 50, 50);
		this.add(lyrics);
	}

	public JSlider getPlaytimeSlider() {
		return playtimeSlider;
	}

	public JButton getSound() {
		return sound;
	}

	public JButton getLyrics() {
		return lyrics;
	}
	
}
