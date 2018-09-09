package com.jplayer.gui.frame;

import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class Playback extends PlaybackListener implements Runnable{

//	Fields
	private boolean pauseFlag;
	private AdvancedPlayer player;
	private FileInputStream input;
	private long totalLeft;
	private long currentlyLeft;
	private int index;
	
	private Thread playbackThread;
	
//	Setter method
	public void setIndex(int index) {
		this.index = index;
	}
	
//	Run method
	public void run() {

		try {
			input = new FileInputStream(Frame.playList.elementAt(index));
			if(player == null) {
				totalLeft = input.available();
				player = new AdvancedPlayer(input);
				System.out.println("Total bytes left at starting point : "+totalLeft+"bytes");
				System.out.println("Play Started!");
//				player.setPlayBackListener(this);
				player.play();
			}
			else if(pauseFlag) {
				input.skip(totalLeft - currentlyLeft);
				player = new AdvancedPlayer(input);
				System.out.println("Resume Started!");
//				player.setPlayBackListener(this);
				player.play();
			}
			else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		playbackThread = new Thread(this);
		playbackThread.setDaemon(true);
		playbackThread.start();
		System.out.println("Thread Started!");
	}

	public void pause() {
		try {
			if(player != null) {
				currentlyLeft = input.available();
				System.out.println("Bytes left at paused point : "+currentlyLeft+"bytes");
				System.out.println("Player Paused!");
				player.close();
				playbackThread.interrupt();
				pauseFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		if(player != null) {
			System.out.println("Player Stopped!");
			player.close();
			playbackThread.interrupt();
			player = null;
		}
	}
	
//	PlaybackListener methods
	public void playbackStarted(PlaybackEvent event) {
		System.out.println("Playback Started!");
	}
	
	public void playbackFinished(PlaybackEvent event) {
		System.out.println("Playback Finished!");
	}
}
