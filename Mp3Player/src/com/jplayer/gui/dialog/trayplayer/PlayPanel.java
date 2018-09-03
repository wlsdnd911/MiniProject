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
				chooser.showOpenDialog(null);//���Ͽ��� â
				songFile = chooser.getSelectedFile();//������ ���� ��������
//				System.out.println("songFile : " + songFile);
				
				AdvancedPlayer p = new AdvancedPlayer(new FileInputStream(songFile));
				
				//������ �̸��� .mp3�� ������ ������ ���� �޽��� ǥ��
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
			System.out.println("��������");
			System.out.println(e.getSource());
			if(e.getSource() == previousBtn) {
//				�������� ���
			}
		});
		
		/**
		 * ���� ���
		 */
		playBtn.addActionListener(e->{
			if(e.getSource() == playBtn) {
				play.start();
			}
			try {
				AdvancedPlayer p = new AdvancedPlayer(new FileInputStream(songFile));
				//���� ������ ������ ����
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
			if(button.getActionCommand().equals(playBtn.getText())){//�׼�Ŀ�ǵ��  ��ư�� �۾��� ������
				playBtn.setText("stop");
			}
			
			if(button.getActionCommand().equals(playBtn.getText())) {//�ؼ�Ŀ�ǵ�� ��ư�� �۾��� �ٸ���
				playBtn.setText("play");
			}
		});
		
		
		
		
		nextBtn.addActionListener(e->{
			System.out.println("������");
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

