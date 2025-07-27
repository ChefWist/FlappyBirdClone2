package main;

import javax.swing.*;
import background.*;
import game.*;
import user_interface.*;

import java.awt.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	
	// Screen Settings
	public final int screenWidth = 288;
	public final int screenHeight = 512;
	
	public final int backgroundSpeed = 5;
	public Background bg;
	public Base base1;
	public Base base2;
	
	public HelpInfo helpInfo;
	public GameOver gameOver;
	
	public int score;
	
	public Pipe pipe;
	public Bird bird;
	
	public GameState state = GameState.MENU;
	public ScoreDisplay scoreD;
	public InputHandler inputH;
	Thread gameThread;
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.black);
		setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		double delta = 0;
		double currentTime;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - nextDrawTime) / drawInterval;
			
			if (delta > 1) {
				update();
				repaint();
				delta--;
				nextDrawTime += drawInterval;
			}
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
		g2.dispose();
	}
	
	public void update() {
		
		base1.update();
		base2.update();
		
		bird.update();
		pipe.update();
	}
	
	public void draw(Graphics2D g) {
		
		bg.draw(g);
		bird.draw(g);
		pipe.draw(g);
		base1.draw(g);
		base2.draw(g);
		
		scoreD.draw(g);
		
		if (state == GameState.MENU) {
			helpInfo.draw(g);
		}
		if (state == GameState.GAME_OVER) {
			gameOver.draw(g);
		}
	}
	
	public void reset() {
		
		inputH = new InputHandler();
		addKeyListener(inputH);
		addMouseListener(inputH);
		
		base1 = new Base(0, screenHeight-Main.baseImg.getHeight());
		base2 = new Base(screenWidth, screenHeight-Main.baseImg.getHeight());
		bg = new Background();
		
		bird = new Bird();
		pipe = new Pipe(screenWidth * 2);
		
		scoreD = new ScoreDisplay();
		score = 0;
		
		helpInfo = new HelpInfo();
		gameOver = new GameOver();
		
		if (state != GameState.MENU)
		state = GameState.PLAYING;
	}
	
	public enum GameState {
		
		// All Game States
		MENU(0),
		PLAYING(1),
		GAME_OVER(2);
		
		public int state;
		GameState(int state) {
			this.state = state;
		}
		
	}
	
}
