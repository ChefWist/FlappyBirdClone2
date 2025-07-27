package main;

/*
 * Used for loading all assets
 * e.g sounds, music, art
 */

import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.sound.sampled.*;

public class AssetHandler {}

abstract class ImageLoader {
	
	private ImageLoader() {}
	
	public static BufferedImage loadImage(String fileName) {
		try {
			return ImageIO.read(new AssetHandler().getClass().getResourceAsStream("/assets/sprites/"+fileName+".png"));
		} catch (IOException e) {
			
			System.out.println("Error loading image: " + fileName);
			return null;
		}
	}
}

//abstract class SoundHandler {
//	
//	public static ArrayList<String> filePaths = new ArrayList<>();
//	public static AudioInputStream ais;
//	public static Clip clip;
//	
//	public static int addSound(String fileName) {
//		filePaths.add("assets/sounds/"+fileName+".wav");
//		return filePaths.size()-1;
//	}
//	
//	private static void openClip(int i) {
//		try {
//			ais = AudioSystem.getAudioInputStream(new File(filePaths.get(i)));
//			clip = AudioSystem.getClip();
//			clip.open(ais);
//			
//		} catch (UnsupportedAudioFileException e) {
//			System.out.println("Sound Error 1");
//		} catch (LineUnavailableException e) {
//			System.out.println("Sound Error -1");
//		} catch (IOException e) {
//			System.out.println("Sound Error 3: " + e.getMessage());
//			System.out.println(filePaths.get(i));
//		}
//	}
//	
//	public static void playSound(int i) {
//		
//		openClip(i);
//		clip.start();
//	}
//	
//}

abstract class SoundHandler {

    public static ArrayList<String> filePaths = new ArrayList<>();
    public static AudioInputStream ais;
    public static Clip clip;

    public static int addSound(String fileName) {
        filePaths.add("/assets/sounds/" + fileName + ".wav"); // no 'src'
        return filePaths.size() - 1;
    }

    private static void openClip(int i) {
        try {
            InputStream is = SoundHandler.class.getResourceAsStream(filePaths.get(i));
            if (is == null) {
                System.out.println("Sound Error: Resource not found -> " + filePaths.get(i));
                return;
            }

            ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Sound Error 1");
        } catch (LineUnavailableException e) {
            System.out.println("Sound Error -1");
        } catch (IOException e) {
            System.out.println("Sound Error 3: " + e.getMessage());
            System.out.println(filePaths.get(i));
        }
    }

    public static void playSound(int i) {
        openClip(i);
        if (clip != null) {
            clip.start();
        }
    }
}
