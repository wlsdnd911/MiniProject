package com.jplayer.gui.dialog.trayplayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jplayer.gui.main.Main;
import com.jplayer.util.MusicPlay;
import com.jplayer.util.MusicPlay;

import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 * previous, play, next, album icon
 * 
 * @author Jeong Jin Ung
 */
public class PlayPanel extends JPanel {

	private JButton previousBtn;
	private JButton playBtn;
	private JButton stopBtn;
	private JButton nextBtn;
	private JLabel albumIconLb;
	
	private MusicPlay mp = new MusicPlay();


	public void display() {
//		setBackground(Color.red);
		setLayout(null);

		previousBtn = new JButton("¡å");
		previousBtn.setBounds(0, 0, 60, 23);
		add(previousBtn);

		playBtn = new JButton("¢¹");
		playBtn.setBounds(15, 0, 60, 23);
		add(playBtn);
		
		stopBtn = new JButton("¡«");
		stopBtn.setBounds(15, 0, 60, 23);
		add(stopBtn);
		stopBtn.setVisible(false);

		nextBtn = new JButton("¡à");
		nextBtn.setBounds(30, 0, 60, 23);
		add(nextBtn);

		albumIconLb = new JLabel("albumIcon");
		albumIconLb.setBounds(45, 0, 79, 80);
		add(albumIconLb);
	}

	public void event() {
		
		playBtn.addActionListener(e->{
			this.playStart();
		});
		
		stopBtn.addActionListener(e->{
			this.playPause();
		});
		
		nextBtn.addActionListener(e->{
			this.playClose();
		});
		
//		previousBtn.addActionListener(e->{
//			mp.getFile();
//			
//		});
		
	}
	
	// constructor
	public PlayPanel() {
		this.display();
		this.event();
	}
	
	//setter, getter
	public JButton getPreviousBtn() {
		return previousBtn;
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public JButton getStopBtn() {
		return stopBtn;
	}

	public JButton getNextBtn() {
		return nextBtn;
	}

	public JLabel getAlbumIconLb() {
		return albumIconLb;
	}

	public MusicPlay getMp() {
		return mp;
	}
	
	//method
	
	public void playStart() {
//		chooser = new JFileChooser();
//		chooser.showOpenDialog(null);
//		songFile = chooser.getSelectedFile();
		File songFile = new File("powerup.mp3");
		mp.setFile(songFile);
		mp.firstPlay();
		mp.setPlay(true);
		playBtn.setVisible(false);
		stopBtn.setVisible(true);
	}
	
	public void playPause() {
		mp.setPlay(true);
		mp.pause();
		mp.setPlay(true);
		stopBtn.setVisible(false);
		playBtn.setVisible(true);
	}
	
	public void playClose() {
		if(mp.getFile() != null) {
			mp.playerClosed();
			stopBtn.setVisible(false);
			playBtn.setVisible(true);
		}
	}
	
}
