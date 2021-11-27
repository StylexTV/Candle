package de.stylextv.candle.asset.types;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import de.stylextv.candle.asset.Asset;

public class ImageAsset extends Asset {
	
	private static final String FILE_ENDING = ".png";
	
	private BufferedImage image;
	
	private boolean loaded;
	
	public ImageAsset(String path) {
		super(path + FILE_ENDING);
	}
	
	private void load() {
		if(loaded) return;
		
		try {
			
			InputStream stream = asStream();
			
			image = ImageIO.read(stream);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		loaded = true;
	}
	
	public int getWidth() {
		BufferedImage image = getImage();
		
		return image.getWidth();
	}
	
	public int getHeight() {
		BufferedImage image = getImage();
		
		return image.getHeight();
	}
	
	public BufferedImage getImage() {
		load();
		
		return image;
	}

}
