package de.stylextv.candle.render.asset.texture;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL30;

import de.stylextv.candle.asset.Asset;
import de.stylextv.candle.util.image.ImageUtil;

public class Texture extends Asset {
	
	private int pointer;
	
	@Override
	public void create() {
		super.create();
		
		pointer = GL30.glGenTextures();
		
		bind();
		
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_WRAP_S, GL30.GL_REPEAT);
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_WRAP_T, GL30.GL_REPEAT);
		
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MIN_FILTER, GL30.GL_NEAREST);
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MAG_FILTER, GL30.GL_NEAREST);
	}
	
	public void load(BufferedImage image) {
		bind();
		
		ByteBuffer buffer = ImageUtil.imageToBuffer(image);
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		load(width, height, GL30.GL_RGBA, buffer);
	}
	
	public void load(int width, int height) {
		load(width, height, GL30.GL_RGB);
	}
	
	public void load(int width, int height, int format) {
		load(width, height, format, null);
	}
	
	public void load(int width, int height, int format, ByteBuffer buffer) {
		bind();
		
		GL30.glTexImage2D(GL30.GL_TEXTURE_2D, 0, format, width, height, 0, format, GL30.GL_UNSIGNED_BYTE, buffer);
	}
	
	@Override
	public void destroy() {
		GL30.glDeleteTextures(pointer);
		
		super.destroy();
	}
	
	public void bind() {
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, pointer);
	}
	
	public int getPointer() {
		return pointer;
	}
	
}
