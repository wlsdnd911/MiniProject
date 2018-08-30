package com.jplayer.gui.dialog.player;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * previous, play, next, album icon 
 * @author Jeong Jin Ung
 */
public class PlayPanel extends JPanel {
	
	private JButton previousBtn;
	private JButton playBtn;
	private JButton nextBtn;
	private JLabel albumIconLb; 
	
	public void display() {
//		setBackground(Color.red);
		setLayout(null);
		
		previousBtn = new JButton("previous");
		previousBtn.setBounds(0, 0, 60, 23);
		add(previousBtn);
		
		playBtn = new JButton("play");
		playBtn.setBounds(15, 0, 60, 23);
		add(playBtn);
		
		nextBtn = new JButton("next");
		nextBtn.setBounds(30, 0, 60, 23);
		add(nextBtn);
		
		albumIconLb = new JLabel("albumIcon");
		albumIconLb.setBounds(45, 0, 79, 80);
		add(albumIconLb);
	}
	
	public void event() {
		
		previousBtn.addActionListener(e->{
			System.out.println("¿Ã¿¸¿Ωæ«");
		});
		
		playBtn.addActionListener(e->{
			System.out.println("¿Ωæ«¿Áª˝");
		});
		
		nextBtn.addActionListener(e->{
			System.out.println("¥Ÿ¿Ω∞Ó");
		});
		
	}
	
	//constructor
	public PlayPanel() {
		this.display();
		this.event();
	}

	public JButton getPreviousBtn() {
		return previousBtn;
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public JButton getNextBtn() {
		return nextBtn;
	}

	public JLabel getAlbumIconLb() {
		return albumIconLb;
	}
		
}

