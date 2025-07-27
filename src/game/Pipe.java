package game;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

import main.*;
import main.GamePanel.GameState;

public class Pipe {
	
	public Random random;
	public BufferedImage img;
	public int x, y;
	
	public boolean given_point;
	public final int gapSize = 100;
	
	GamePanel gp;
	
	public Pipe(int x) {
		
		random = new Random();
		this.gp = Main.gp;
		
		if (random.nextBoolean()) {
			this.img = Main.redPipeImg;
		}
		else {
			this.img = Main.greenPipeImg;
		}
		this.x = x;
		
		setRandomY();
	}
	
	public void update() {
		
		if (gp.state != GameState.PLAYING) return;
		
		x -= gp.backgroundSpeed;
		
		if (x < -img.getWidth()) {
			
			given_point = false;
			x = gp.screenWidth;
			setRandomY();
		}
		
		if (x < gp.bird.x && !given_point) {
			
			gp.score++;
			given_point = true;
			
			Main.playSfx(Main.pointSfx);
		}
		
	}
	
	public void setRandomY() {
		y = random.nextInt(gapSize, gp.base1.y-gapSize);
	}
	
	public void draw(Graphics2D g) {
		
		AffineTransform old = g.getTransform();
		g.drawImage(img, x, y + (gapSize/2), null);
		g.rotate(Math.toRadians(180), x, y - (gapSize/2));
		g.drawImage(img, x - (img.getWidth()), y - (gapSize/2), null);
		g.setTransform(old);
	}
	
}
