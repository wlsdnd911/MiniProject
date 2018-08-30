package com.jplayer.gui.dialog.trayplayer;

import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * play slider, start time, end time
 * @author Jeong Jin Ung
 */
public class SliderPanel extends JPanel {
	
	private JSlider playSlider;
	private JLabel timeLb;
	private JLabel timeLb_2;
	
	public SliderPanel() {
		setLayout(null);
//		setBackground(Color.blue);
		
		playSlider = new JSlider();
		
		playSlider.setBounds(0, 0, 326, 22);
		add(playSlider);
		
		timeLb = new JLabel("start");
		timeLb.setBounds(0, 30, 50, 15);
		add(timeLb);
		
		timeLb_2 = new JLabel("end");
		timeLb_2.setBounds(65, 30, 50, 15);
		add(timeLb_2);
	}

	public JSlider getPlaySlider() {
		return playSlider;
	}

	public JLabel getTimeLb() {
		return timeLb;
	}

	public JLabel getTimeLb_2() {
		return timeLb_2;
	}
	
	
	

}
