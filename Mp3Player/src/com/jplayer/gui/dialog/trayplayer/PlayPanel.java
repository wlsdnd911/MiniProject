package com.jplayer.gui.dialog.trayplayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jplayer.util.Mp3Manager;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 * previous, play, next, album icon 
 * @author Jeong Jin Ung
 */
public class PlayPanel extends JPanel{
	
	private JButton previousBtn;
	private JButton playBtn;
	private JButton nextBtn;
	private JLabel albumIconLb;
	
	private Player player;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private File songFile;
	private int pauseOnFrame = 0;
	
	Mp3Manager manager = new Mp3Manager();
	
	public void display() {
//		setBackground(Color.red);
		setLayout(null);
		
		previousBtn = new JButton("previous");
		previousBtn.setBounds(0, 0, 60, 23);
		add(previousBtn);
		
		playBtn = new JButton("play");
		playBtn.setBounds(15, 0, 60, 23);
		add(playBtn);
		
		nextBtn = new JButton("next");
		nextBtn.setBounds(30, 0, 60, 23);
		add(nextBtn);
		
		albumIconLb = new JLabel("albumIcon");
		albumIconLb.setBounds(45, 0, 79, 80);
		add(albumIconLb);
	}
	
	Runnable playStart = new Runnable() {
		@Override
		public void run() {
			try {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("choose song to loading...");
				chooser.showOpenDialog(null);//파일열기 창
				songFile = chooser.getSelectedFile();//선택한 파일 가져오기
//				System.out.println("songFile : " + songFile);
				
				AdvancedPlayer p = new AdvancedPlayer(new FileInputStream(songFile));
				
				//파일의 이름이 .mp3로 끝나지 않으면 에러 메시지 표시
				if(!songFile.getName().endsWith(".mp3")) {
					JOptionPane.showMessageDialog(
							null, "Error", "Invalid File Type Selected!", JOptionPane.ERROR_MESSAGE);
				}
				p.play();
				System.out.println(p.getPlayBackListener());
				
			} catch(Exception noFile) {
				noFile.printStackTrace();
			}
			
		}
	};

	
	public void event() {
		
		Thread play = new Thread(playStart);
		
		previousBtn.addActionListener(e->{
			System.out.println("이전음악");
			System.out.println(e.getSource());
			if(e.getSource() == previousBtn) {
//				이전음악 재생
			}
		});
		
		/**
		 * 음악 재생
		 */
		playBtn.addActionListener(e->{
			if(e.getSource() == playBtn) {
				play.start();
			}
			try {
				AdvancedPlayer p = new AdvancedPlayer(new FileInputStream(songFile));
				//포즈 했을때 프레임 저장
				p.setPlayBackListener(new PlaybackListener() {
					@Override
					public void playbackFinished(PlaybackEvent event) {
						pauseOnFrame = event.getFrame();
						System.out.println(pauseOnFrame);
					}
				});
				p.stop();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			
		});//evnet
		
		playBtn.addActionListener(button->{
			if(button.getActionCommand().equals(playBtn.getText())){//액션커맨드와  버튼의 글씨가 같으면
				playBtn.setText("stop");
			}
			
			if(button.getActionCommand().equals(playBtn.getText())) {//앤션커맨드와 버튼의 글씨가 다르면
				playBtn.setText("play");
			}
		});
		
		
		
		
		nextBtn.addActionListener(e->{
			System.out.println("다음곡");
		});
	}
	
	//constructor
	public PlayPanel() {
		this.display();
		this.event();
	}

	public JButton getPreviousBtn() {
		return previousBtn;
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public JButton getNextBtn() {
		return nextBtn;
	}

	public JLabel getAlbumIconLb() {
		return albumIconLb;
	}
		
}

