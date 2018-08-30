package com.jplayer.gui.dialog.trayplayer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * title, song name, singer
 * @author Jeong Jin Ung
 */
public class InfoPanel extends JPanel{
	
	private JLabel playerNameLb;
	private JLabel songNameLb;
	private JLabel singerLb;
	
	public InfoPanel() {
		
//		setBackground(Color.YELLOW);
		setLayout(null);
		
		playerNameLb = new JLabel("J Play Music");
		playerNameLb.setBounds(0, 0, 184, 15);
		add(playerNameLb);
		
		songNameLb = new JLabel("songName");
		songNameLb.setBounds(0, 30, 184, 15);
		add(songNameLb);
		
		singerLb = new JLabel("singer");
		singerLb.setBounds(0,60, 184, 15);
		add(singerLb);
		
	}

	public JLabel getPlayerNameLb() {
		return playerNameLb;
	}

	public JLabel getSongNameLb() {
		return songNameLb;
	}

	public JLabel getSingerLb() {
		return singerLb;
	}
}
