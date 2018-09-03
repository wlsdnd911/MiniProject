package com.jplayer.gui.dialog.trayplayer;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * relative window
 * @author Jeong Jin Ung
 */
public class PlayerDialogMain extends JDialog {
	
	private JPanel mainPanel = new JPanel();
	private JPanel infoP = new JPanel();
	private JPanel playP = new JPanel();
	private JPanel sliderP = new JPanel();
	private JPanel utilP = new JPanel();
		
	public void display() {
		//main panel
		this.setContentPane(mainPanel);
		this.mainPanel.setLayout(null);

		//info panel
		infoP.setBounds(12, 10, 200, 83);
		mainPanel.add(infoP);
		infoP.setLayout(null);
		InfoPanel ip = new InfoPanel();
		ip.getSingerLb().setLocation(12, 55);
		ip.getSongNameLb().setLocation(12, 30);
		ip.getPlayerNameLb().setLocation(12, 5);
		ip.setBounds(0, 0, 200, 83);
		infoP.add(ip);
		
		//play panel
		playP.setBounds(224, 10, 325, 83);
		mainPanel.add(playP);//메인패널에 서브패널 추가
		playP.setLayout(null);//서브패널 레이아웃 지정
		PlayPanel pp = new PlayPanel();
		pp.getAlbumIconLb().setSize(79, 63);
		pp.setBounds(0, 0, 325, 83);
		playP.add(pp);
		pp.getNextBtn().setLocation(156, 31);
		pp.getPlayBtn().setLocation(84, 31);
		pp.getPreviousBtn().setLocation(12, 31);
		pp.getAlbumIconLb().setLocation(234, 10);
		
		//slider panel
		sliderP.setBounds(12, 103, 430, 68);
		mainPanel.add(sliderP);
		sliderP.setLayout(null);
		SliderPanel sp =  new SliderPanel();
		sp.getPlaySlider().setBounds(0, 0, 430, 22);
		sp.getTimeLb().setLocation(10, 32);
		sp.getTimeLb_2().setLocation(368, 32);
		sp.setBounds(0, 0, 430, 68);
		sliderP.add(sp);
		
		//util panel
		utilP.setBounds(454, 103, 95, 68);
		mainPanel.add(utilP);
		utilP.setLayout(null);
		UtilPanel up = new UtilPanel();
		up.getLyricsBtn().setLocation(12, 36);
		up.getSoundBtn().setLocation(12, 10);
		up.setBounds(0, 0, 95, 68);
		utilP.add(up);
	}

	public void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	/*	WindowListener close = new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(FrameMain, "Closing", "close", JOptionPane.OK_CANCEL_OPTION);
				if(a==0) {
					dispose();
				}
			}
		};*/
	}
	
	/**
	 * constructor
	 */
	public PlayerDialogMain() {
		
		this.display();
		this.event();
		//player dialog screen setting
		this.setTitle("Jplayer");
		this.setLocation(100, 100);
		this.setLocationByPlatform(true);
		this.setSize(575, 213);
		this.setResizable(false);
		this.setVisible(true);	
	}
}

