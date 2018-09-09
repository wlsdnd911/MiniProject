package com.jplayer.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener, MouseListener{

//	Fields
	private JPanel panel = new JPanel();
	
	private JButton openBtn;
	private JButton playBtn;
	private JButton pauseBtn;
	private JButton stopBtn;
	private JButton nextBtn;
	private JButton prevBtn;
	private JLabel label;
	
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file  = new JMenu("File");
	private JMenuItem add = new JMenuItem("Add File(s)");
	private JMenuItem del = new JMenuItem("Delete File(s)");
	private JMenuItem exit = new JMenuItem("Exit");
	
	private JMenu playbackM = new JMenu("Playback");
	private JMenuItem play = new JMenuItem("Play");
	private JMenuItem pause = new JMenuItem("Pause");
	private JMenuItem stop = new JMenuItem("Stop");
	private JMenuItem next = new JMenuItem("Next");
	private JMenuItem prev = new JMenuItem("Prev");
	
	private JMenu help = new JMenu("Help");
	private JMenuItem info = new JMenuItem("Developer info");
	
	static ArrayList<File> fileList = new ArrayList<>();
	static DefaultListModel<File> playList = new DefaultListModel<>();
	static JList<File> list = new JList<>(playList);
	
	private JScrollPane jsp;
	private int index;
	
	private Playback playback = new Playback();
	
	public void display() {
		setContentPane(panel);
		panel.setLayout(null);
		
//		Initiate Components
		label = new JLabel("Title : ", JLabel.LEFT);
		label.setBounds(320, 10, 500, 50);
		panel.add(label);
		
		openBtn = new JButton("Open");
		openBtn.setBounds(10, 10, 50, 50);
		panel.add(openBtn);
		
		playBtn = new JButton("▷");
		playBtn.setBounds(60, 10, 50, 50);
		panel.add(playBtn);
		
		stopBtn = new JButton("□");
		stopBtn.setBounds(110, 10, 50, 50);
		panel.add(stopBtn);
		
		prevBtn = new JButton("|◁");
		prevBtn.setBounds(160, 10, 50, 50);
		panel.add(prevBtn);

		pauseBtn = new JButton("||");
		pauseBtn.setBounds(210, 10, 50, 50);
		panel.add(pauseBtn);
		
		nextBtn = new JButton("▷|");
		nextBtn.setBounds(260, 10, 50, 50);
		panel.add(nextBtn);
		
		jsp = new JScrollPane(list);
		jsp.setBounds(10, 70, 965, 460);
		panel.add(jsp);
	}
	
//	메뉴 구현 기능
	public void menu() {
		setJMenuBar(bar);
		bar.add(file);
		bar.add(playbackM);
		bar.add(help);
		
		file.add(add);
		file.add(del);
		file.addSeparator();
		file.add(exit);
		
		playbackM.add(play);
		playbackM.add(pause);
		playbackM.add(stop);
		playbackM.addSeparator();
		playbackM.add(next);
		playbackM.add(prev);
		
		help.add(info);
	}
	
//	이벤트 처리 기능
	public void event() {
		openBtn.addActionListener(this);
		playBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		list.addMouseListener(this);
		
		add.addActionListener(this);
		del.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Add file(s)
		if(e.getSource() == openBtn || e.getSource() == add) {
			JFileChooser chooser = new JFileChooser(/*"C:\\Users\\정세영\\Desktop\\음악\\OST\\The Post"*/);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 file", "mp3");
			chooser.setFileFilter(filter);
			chooser.setMultiSelectionEnabled(true);
			chooser.setDialogTitle("Select a file");
			int ret = chooser.showOpenDialog(panel);
			if(ret == JFileChooser.CANCEL_OPTION) {
				return;
			}
			if(ret == JFileChooser.APPROVE_OPTION) {
				File[] tmpFiles = chooser.getSelectedFiles();
				for(int i=0; i<tmpFiles.length; i++) {
					fileList.add(tmpFiles[i]);
				}
				System.out.println(fileList.size());
				
				Iterator<File> it = fileList.iterator();
				
				File tmpFile;
				while(it.hasNext()) {
					tmpFile = it.next();
					playList.add(playList.getSize(), tmpFile);
				}
			}
			list.setModel(playList);
			System.out.println(playList.size());
		}
		
		// Delete file(s)
		if(e.getSource() == del) {
			
		}
		
		// Exit
		if(e.getSource() == exit) {
			System.exit(0);
		}		
		
		// Play
		if(e.getSource() == playBtn || e.getSource() == play) {
			label.setText("Now playing : "+playList.elementAt(index).getName());
			playback.play();
		}
		
		// Pause
		if(e.getSource() == pauseBtn || e.getSource() == pause) {
			label.setText("Paused : "+playList.elementAt(index).getName());
			playback.pause();
		}
		
		// Stop
		if(e.getSource() == stopBtn || e.getSource() == stop) {
			label.setText("Stopped");
			playback.stop();
		}
		
		// Developer info
		if(e.getActionCommand().equals(info.getText())) {
			JOptionPane.showMessageDialog(
					this, "Version 1.0"+"\n Developer : Jeong Jinung, Chung Seyoung", "MP3 Player", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void mouseClicked(MouseEvent e) {	
		if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
			index = list.locationToIndex(e.getPoint());
			System.out.println(index);
			playback.setIndex(index);
		}
	}

	public void mouseEntered(MouseEvent arg0) {}
	
	public void mouseExited(MouseEvent arg0) {}
	
	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}
	
//	생성자
	public Frame() {
		display();
		menu();
		event();
		
		setTitle("MP3 Player");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(1000, 600);
		setResizable(false);
		setVisible(true);
	}
}
