package background;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import main.*;

public class Background {
	
	public Random random = new Random();
	public BufferedImage image;
	
	public Background() {
		
		if (random.nextBoolean()) {
			image = Main.bgNightImg;
		}
		else {
			image = Main.bgDayImg;
		}
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, 0, 0, null);
	}
}
