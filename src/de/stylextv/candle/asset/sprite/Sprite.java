package de.stylextv.candle.asset.sprite;

import java.awt.image.BufferedImage;

import de.stylextv.candle.asset.types.ImageAsset;
import de.stylextv.candle.render.asset.texture.Texture;

public class Sprite extends ImageAsset {
	
	private static final String FOLDER = "sprites/";
	
	private Texture texture;
	
	public Sprite(String path) {
		super(FOLDER + path);
	}
	
	@Override
	public void create() {
		super.create();
		
		texture = new Texture();
		
		BufferedImage image = getImage();
		
		texture.load(image);
	}
	
	@Override
	public void destroy() {
		texture.destroy();
		
		super.destroy();
	}
	
	public Texture getTexture() {
		return texture;
	}
	
}
