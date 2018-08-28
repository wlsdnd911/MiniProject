package com.jplayer.gui.frame;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

class JFrameEx extends JFrame{
	
	private JPanel panel =new JPanel(); 
	
	private JMenuBar bar = new JMenuBar();
	
	private JMenu menu = new JMenu("�޴�");
	private JMenuItem file = new JMenuItem("���� ����");
	private JMenuItem folder = new JMenuItem("���� ����");
	private JMenuItem exit = new JMenuItem("����");
	
	private JMenu playback = new JMenu("�÷��̹�");
	private JMenuItem play = new JMenuItem("���");	
	private JMenuItem pause = new JMenuItem("�Ͻ�����");
	private JMenuItem stop = new JMenuItem("����");
	private JMenuItem next = new JMenuItem("������");
	private JMenuItem previous = new JMenuItem("������");
			
	private JMenu edit = new JMenu("ȯ�漳��");
	private JMenuItem color = new JMenuItem("���󺯰�");
	
	private JMenu help = new JMenu("����");
	private JMenuItem info = new JMenuItem("������ ����");
	
//	ȭ�� ó�� ���
	public void display() {
		this.setContentPane(panel);
		panel.setLayout(null);		
		
	}
	
//	�޴� ���� ���
	public void menu() {
		this.setJMenuBar(bar);
		bar.setOpaque(true);
		bar.setBackground(Color.PINK);
		
		bar.add(menu);
		bar.add(playback);
		bar.add(edit);
		bar.add(help);
		
		menu.add(file);
		menu.add(folder);
		menu.add(exit);
		
		playback.add(play);
		playback.add(pause);
		playback.add(stop);
		playback.add(next);
		playback.add(previous);
		
		edit.add(color);
		
		help.add(info);
	}
	
//	�̺�Ʈ ó�� ���
	public void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
		info.addActionListener(e->{
			JOptionPane.showMessageDialog(panel, "������ : SW-5 4��");
		});
	}

//	������
	JFrameEx(){
		this.display();
		this.menu();
		this.event();
		
		this.setTitle("MP3 �÷��̾�");
		this.setLocationByPlatform(true);
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test01 {
	public static void main(String[] args) {
		JFrameEx frame = new JFrameEx();
	}
}
