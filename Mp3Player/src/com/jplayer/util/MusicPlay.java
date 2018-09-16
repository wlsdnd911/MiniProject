package com.jplayer.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;

import com.jplayer.gui.dialog.trayplayer.PlayPanel;

import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlay implements Runnable{
	
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private Player player;
	private Thread thread;
	private boolean isPlay = false;
	
	private int startOnPosition;
	private int pausedOnPosition;
		
	@Override
	public void run() {	
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			if(isPlay==true) {
				bis.skip(startOnPosition - pausedOnPosition);
				player = new Player(bis);
				System.out.println("일시정지: "+ pausedOnPosition);
				player.play();
			}else if(isPlay==false) {
				System.out.println("바로재생:" + pausedOnPosition);
				player = new Player(bis);
				startOnPosition = bis.available();
				player.play();
				
			}else {
				return;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method
	public void firstPlay() {
		thread = new Thread(this);;
		thread.setDaemon(true);
		thread.start();
		System.err.println("쓰레드 스타트 : " + thread.getName());
	}
		
	public void pause() {
		try {
			pausedOnPosition = bis.available();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		player.close();
		thread.interrupt();
		System.out.println("정지했을때 위치 : " + pausedOnPosition);
	}
	
//	public void viewLyrics() {
//		if(file.isFile()) {
//			File[] list = 
//		}
//	}
	
	//setter, getter
	public void playerClosed() {
		player.close();
		thread.interrupt();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}

	public BufferedInputStream getBis() {
		return bis;
	}

	public void setBis(BufferedInputStream bis) {
		this.bis = bis;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public boolean isPlay() {
		return isPlay;
	}

	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}

	public int getStartOnPosition() {
		return startOnPosition;
	}

	public void setStartOnPosition(int startOnPosition) {
		this.startOnPosition = startOnPosition;
	}

	public int getPausedOnPosition() {
		return pausedOnPosition;
	}

	public void setPausedOnPosition(int pausedOnPosition) {
		this.pausedOnPosition = pausedOnPosition;
	}


}
