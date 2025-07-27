package game;

import java.awt.event.*;
import main.*;
import main.GamePanel.*;

public class InputHandler implements KeyListener,
									 MouseListener
{
	
	GamePanel gp;
	public InputHandler() {
		this.gp = Main.gp;
	}
	
	/* MOUSE HANDLER */
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (gp.state == GameState.GAME_OVER) {
			gp.reset();
		}
		else if (gp.state == GameState.MENU) {
			gp.state = GameState.PLAYING;
			gp.bird.jump();
		}
		else {
			gp.bird.jump();
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	
	/* KEY HANDLER */
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		
		if (gp.state == GameState.GAME_OVER) {
			gp.reset();
		}
		else if (gp.state == GameState.MENU) {
			gp.state = GameState.PLAYING;
			gp.bird.jump();
		}
		else {
			gp.bird.jump();
		}
	}
	
}
