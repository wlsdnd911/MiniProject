import java.awt.Color;

import javax.swing.*;
import java.awt.*;

class JFrameEx2 extends JFrame{
	
	private JPanel panel =new JPanel(); 
	
	private JToolBar toolBar = new JToolBar();
	private JButton playButton = new JButton("재생");
	private JButton pauseButton = new JButton("일시정지");
	private JButton stopButton = new JButton("정지");
	private JButton nextButton = new JButton("다음곡");
	private JButton previousButton = new JButton("이전곡");
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menu = new JMenu("메뉴");
	private JMenuItem file = new JMenuItem("파일 열기");
	private JMenuItem folder = new JMenuItem("폴더 열기");
	private JMenuItem exit = new JMenuItem("종료");
	
	private JMenu playback = new JMenu("플레이백");
	private JMenuItem play = new JMenuItem("재생");	
	private JMenuItem pause = new JMenuItem("일시정지");
	private JMenuItem stop = new JMenuItem("정지");
	private JMenuItem next = new JMenuItem("다음곡");
	private JMenuItem previous = new JMenuItem("이전곡");
			
	private JMenu edit = new JMenu("환경설정");
	private JMenuItem color = new JMenuItem("색상변경");
	
	private JMenu help = new JMenu("도움말");
	private JMenuItem info = new JMenuItem("개발자 정보");
	
//	화면 처리 기능
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
	
//	메뉴 구현 기능
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
	
//	이벤트 처리 기능
	public void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
		info.addActionListener(e->{
			JOptionPane.showMessageDialog(panel, "개발자 : SW-5 4팀");
		});
	}

//	생성자
	JFrameEx2(){
		this.display();
		this.menu();
		this.event();
		
		this.setTitle("MP3 플레이어");
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
