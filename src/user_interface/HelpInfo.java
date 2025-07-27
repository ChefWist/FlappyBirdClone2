package user_interface;

import java.awt.*;
import java.awt.image.*;
import main.*;

public class HelpInfo {
	
	public BufferedImage image;
	
	public HelpInfo() {
		
		image = Main.helpImg;
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, 2, 40, (int) (image.getWidth()*1.55), (int) (image.getHeight()*1.55),  null);
	}
}
