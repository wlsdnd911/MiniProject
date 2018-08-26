import java.awt.Color;

import javax.swing.*;
import java.awt.*;

class JFrameEx2 extends JFrame{
	
	private JPanel panel =new JPanel(); 
	
	private JToolBar toolBar = new JToolBar();
	private JButton playButton = new JButton("���");
	private JButton pauseButton = new JButton("�Ͻ�����");
	private JButton stopButton = new JButton("����");
	private JButton nextButton = new JButton("������");
	private JButton previousButton = new JButton("������");
	
	private JMenuBar menuBar = new JMenuBar();
	
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
		panel.add(toolBar);
		
		toolBar.add(playButton);
		toolBar.add(pauseButton);
		toolBar.add(stopButton);
		toolBar.add(nextButton);
		toolBar.add(previousButton);
		
	}
	
//	�޴� ���� ���
	public void menu() {
		this.setJMenuBar(menuBar);
		menuBar.setOpaque(true);
		menuBar.setBackground(Color.PINK);
		
		menuBar.add(menu);
		menuBar.add(playback);
		menuBar.add(edit);
		menuBar.add(help);
		
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
	JFrameEx2(){
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

public class Test02 {
	public static void main(String[] args) {
		JFrameEx2 frame2 = new JFrameEx2();
	}
}
