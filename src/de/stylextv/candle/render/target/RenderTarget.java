package de.stylextv.candle.render.target;

import org.lwjgl.opengl.GL30;

import de.stylextv.candle.asset.Asset;
import de.stylextv.candle.render.asset.texture.Texture;
import de.stylextv.candle.render.resolution.RenderResolution;

public class RenderTarget extends Asset {
	
	public static final RenderTarget SCREEN = new RenderTarget(RenderResolution.HIGH);
	
	public static final RenderTarget LEVEL = new RenderTarget(RenderResolution.LOW);
	public static final RenderTarget LIGHTS = new RenderTarget(RenderResolution.LOW);
	
	private RenderResolution resolution;
	
	private int width;
	private int height;
	
	private int pointer;
	
	private Texture texture;
	
	public RenderTarget(RenderResolution r) {
		this.resolution = r;
	}
	
	@Override
	public void create() {
		super.create();
		
		pointer = GL30.glGenFramebuffers();
		
		bind();
		
		texture = new Texture();
		
		texture.load(width, height);
		
		int i = texture.getPointer();
		
		GL30.glFramebufferTexture2D(GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL30.GL_TEXTURE_2D, i, 0);
		GL30.glDrawBuffer(GL30.GL_COLOR_ATTACHMENT0);
		
		boolean success = GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) == GL30.GL_FRAMEBUFFER_COMPLETE;
		
		if(!success) throw new RuntimeException("Failed to create framebuffer!");
	}
	
	@Override
	public void destroy() {
		GL30.glDeleteFramebuffers(pointer);
		
		texture.destroy();
		
		super.destroy();
	}
	
	public void bind() {
		int width = resolution.getWidth();
		int height = resolution.getHeight();
		
		setSize(width, height);
		
		GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, pointer);
	}
	
	private void setSize(int width, int height) {
		if(this.width == width && this.height == height) return;
		
		this.width = width;
		this.height = height;
		
		create();
	}
	
	public RenderResolution getResolution() {
		return resolution;
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
