package de.stylextv.candle.render.target;

public class RenderTarget {
	
	private int width;
	private int height;
	
	public RenderTarget() {
		this(0, 0);
	}
	
	public RenderTarget(int width, int height) {
		this.width = width;
		this.height = height;
		
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
