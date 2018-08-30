package com.jplayer.gui.dialog.trayplayer;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * sound control, lyrics view
 * @author Jeong Jin Ung
 *
 */
public class UtilPanel extends JPanel{
	
	private JButton soundBtn;
	private JButton lyricsBtn;
	
	public UtilPanel() {
		setLayout(null);
		
		soundBtn = new JButton("sound");
		soundBtn.setBounds(0, 0, 65, 23);
		add(soundBtn);
		
		lyricsBtn = new JButton("lyrics");
		lyricsBtn.setBounds(20, 0, 65, 23);
		add(lyricsBtn);	
	}

	public JButton getSoundBtn() {
		return soundBtn;
	}

	public JButton getLyricsBtn() {
		return lyricsBtn;
	}
	
}
