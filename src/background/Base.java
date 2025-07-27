package background;

import java.awt.*;
import java.awt.image.*;

import main.*;
import main.GamePanel.GameState;

public class Base {
	
	public int x, y;
	
	public BufferedImage image;
	
	public GamePanel gp;
	
	public Base(int x, int y) {
		
		this.gp = Main.gp;
		this.image = Main.baseImg;
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		
		if (gp.state == GameState.GAME_OVER) return;
		
		x -= gp.backgroundSpeed;
		if (x < -image.getWidth()) {
			x = gp.screenWidth;
		}
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, x, y, image.getWidth()+5, image.getHeight(), null);
	}
	
}
