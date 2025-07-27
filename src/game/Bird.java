package game;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;

import main.*;
import main.GamePanel.*;

public class Bird {
	
	// Position/Movement
	public int x, y;
	public double jumpHeight = 8;
	public double gravity = 0.6;
	public double velocityY = 0;
	
	// Animation
	public Random random = new Random();
	public BufferedImage[] frames;
	public double frame = 0;
	
	GamePanel gp;
	
	public Bird() {
		
		this.gp = Main.gp;
		int val = random.nextInt(1, 4);
		switch (val) {
			case 1 -> this.frames = Main.blueBirdFrames;
			case 2 -> this.frames = Main.redBirdFrames;
			case 3 -> this.frames = Main.yellowBirdFrames;
		}
		this.x = gp.screenWidth/8;
		this.y = (gp.screenHeight/2)-(frames[0].getHeight()/2);
	}
	
	public void update() {
		
		// Animation
		frame += 0.2;
		if (((int) frame) >= frames.length) {
			frame = 0;
		}
		
		if (gp.state != GameState.PLAYING) return;
		
		// Gravity
		velocityY += gravity;
		y += velocityY;
		
		if (y > gp.screenHeight-Main.baseImg.getHeight()-frames[0].getHeight()) {
			Main.playSfx(Main.dieFloor_sfx);
			gp.state = GameState.GAME_OVER;
		}
		if (y < 0) {
			Main.playSfx(Main.dieAir_sfx);
			gp.state = GameState.GAME_OVER;
		}
		
		if (checkCollision(gp.pipe)) {
			Main.playSfx(Main.diePipe_sfx);
			gp.state = GameState.GAME_OVER;
		}
	}
	
	public void draw(Graphics2D g) {
		
		AffineTransform old = g.getTransform();
		g.rotate(Math.toRadians(velocityY-5), x, y);
		BufferedImage img = frames[(int) frame];
		g.drawImage(img, x, y, null);
		g.setTransform(old);
	}
	
	public void jump() {
		
		if (gp.state != GameState.PLAYING) return;
		velocityY = -jumpHeight;
		Main.playSfx(Main.flapSfx);
	}
	
	public boolean checkCollision(Pipe p) {
		
		boolean xColliding = x + frames[0].getWidth() > p.x && 
							 x < p.x + p.img.getWidth();
		
		if (!xColliding) {
			return false;
		}
		
		return !(y + frames[0].getHeight() > p.y-(p.gapSize/2) &&
			   y < p.y + (p.gapSize/2));
		
	}
	
}
