package user_interface;

import java.awt.*;
import java.awt.image.*;

import main.*;

public class ScoreDisplay {
	
	public BufferedImage[] images;
	public int y;

	GamePanel gp;
	
	public ScoreDisplay() {
		
		this.gp = Main.gp;
		this.images = Main.numbers;
		y = 50;
	}
	
	public void draw(Graphics2D g) {
		
		int score_int = gp.score;
		String score_txt = Integer.toString(score_int);
		BufferedImage img = images[0];
		int width = img.getWidth();
		int x = (gp.screenWidth/2)-((width/2)*score_txt.length());
		
		for (int i = 0; i < score_txt.length(); i++) {
			img = images[Integer.parseInt(Character.toString(score_txt.charAt(i)))];
			g.drawImage(img, x, y, null);
			x += width;
		}
		
	}
	
}
