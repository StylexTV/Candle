package de.stylextv.candle.render.target;

import org.lwjgl.opengl.GL30;

public class RenderTarget {
	
	public static final RenderTarget LEVEL = new RenderTarget(320, 180);
	public static final RenderTarget LIGHTS = new RenderTarget(320, 180);
	
	private int width;
	private int height;
	
	private int pointer;
	
	public RenderTarget(int width, int height) {
		setSize(width, height);
	}
	
	public void create() {
		pointer = GL30.glGenFramebuffers();
		
		bind();
		
		// create
	}
	
	public void bind() {
		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, pointer);
	}
	
	public void setSize(int width, int height) {
		if(this.width == width && this.height == height) return;
		
		this.width = width;
		this.height = height;
		
		create();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public static void bindDefault() {
		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
	}
	
}
