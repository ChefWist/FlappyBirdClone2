package user_interface;

import java.awt.*;
import java.awt.image.*;
import main.*;

public class GameOver {
	
	public BufferedImage image;
	
	public GameOver() {
		
		image = Main.gameOverImg;
	}
	
	public void draw(Graphics2D g) {
		
		int width = (int) (image.getWidth()*1.25);
		int height = (int) (image.getHeight()*1.25);
		g.drawImage(image, (Main.gp.screenWidth/2)-(width/2), (Main.gp.screenHeight/2)-(height/2), width, height,  null);
	}
}
