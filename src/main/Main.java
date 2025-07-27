package main;

import java.awt.image.*;
import javax.swing.*;

public class Main {
	
	// Window
	public static JFrame frame;
	public static ImageIcon icon;
	public static GamePanel gp;
	
	// Images
	public static BufferedImage baseImg;
	public static BufferedImage bgDayImg;
	public static BufferedImage bgNightImg;
	public static BufferedImage[] yellowBirdFrames;
	public static BufferedImage[] redBirdFrames;
	public static BufferedImage[] blueBirdFrames;
	public static BufferedImage greenPipeImg;
	public static BufferedImage redPipeImg;
	public static BufferedImage[] numbers = new BufferedImage[10];
	public static BufferedImage helpImg;
	public static BufferedImage gameOverImg;
	
	// Sounds
	public static int dieAir_sfx;
	public static int dieFloor_sfx;
	public static int diePipe_sfx;
	public static int pointSfx;
	public static int flapSfx;
	
	public static void main(String[] args) {
		
		loadAllAssets();
		
		frame = new JFrame("Flappy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gp = new GamePanel();
		frame.add(gp);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		gp.reset();
		gp.startGameThread();
		frame.setVisible(true);
		gp.requestFocus();
	}
	
	public static void loadAllAssets() {
		
		// Window
		icon = new ImageIcon(Main.class.getResource("/assets/icon.png"));
		
		/* IMAGES */
		
		// Background
		baseImg = ImageLoader.loadImage("base");
		bgDayImg = ImageLoader.loadImage("background-day");
		bgNightImg = ImageLoader.loadImage("background-night");
		helpImg = ImageLoader.loadImage("message");
		gameOverImg = ImageLoader.loadImage("gameover");
		
		// Bird
		yellowBirdFrames = new BufferedImage[3];
		redBirdFrames = new BufferedImage[3];
		blueBirdFrames = new BufferedImage[3];
		yellowBirdFrames[0] = ImageLoader.loadImage("yellowbird-upflap");
		yellowBirdFrames[1] = ImageLoader.loadImage("yellowbird-midflap");
		yellowBirdFrames[2] = ImageLoader.loadImage("yellowbird-downflap");
		redBirdFrames[0] = ImageLoader.loadImage("redbird-upflap");
		redBirdFrames[1] = ImageLoader.loadImage("redbird-midflap");
		redBirdFrames[2] = ImageLoader.loadImage("redbird-downflap");
		blueBirdFrames[0] = ImageLoader.loadImage("bluebird-upflap");
		blueBirdFrames[1] = ImageLoader.loadImage("bluebird-midflap");
		blueBirdFrames[2] = ImageLoader.loadImage("bluebird-downflap");
		
		// Pipes
		greenPipeImg = ImageLoader.loadImage("pipe-green");
		redPipeImg = ImageLoader.loadImage("pipe-red");
		
		// Text
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = ImageLoader.loadImage(Integer.toString(i));
		}
		
		/* SOUNDS */
		dieAir_sfx = SoundHandler.addSound("die_air");
		dieFloor_sfx = SoundHandler.addSound("die_floor");
		diePipe_sfx = SoundHandler.addSound("die_pipe");
		pointSfx = SoundHandler.addSound("point");
		flapSfx = SoundHandler.addSound("wing");
	}
	
	public static void playSfx(int i) {
		SoundHandler.playSound(i);
	}
	
}
