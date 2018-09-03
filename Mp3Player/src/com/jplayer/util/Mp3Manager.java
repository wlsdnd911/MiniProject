package com.jplayer.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;

import javafx.stage.FileChooser;
import javazoom.jl.player.Player;

public class Mp3Manager extends Thread{
	
	private Player player;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	private JFileChooser chooser;
	private File songFile;
	private int pauseOnFrame = 0;
	/**
	 * 음악 재생하는 메소드
	 */
	public void musicPlay() {
		try {
			chooser.showOpenDialog(null);
			songFile = new JFileChooser().getSelectedFile();
			fis = new FileInputStream(songFile);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@Override
	public void run() {
		try {
			player.play();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	


}
