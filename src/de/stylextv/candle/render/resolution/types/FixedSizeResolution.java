package de.stylextv.candle.render.resolution.types;

import de.stylextv.candle.render.resolution.RenderResolution;
import de.stylextv.candle.window.Window;

public class FixedSizeResolution extends RenderResolution {
	
	private int width;
	private int height;
	
	public FixedSizeResolution(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void fitWindow(Window w) {
		int width = w.getWidth();
		int height = w.getHeight();
		
		setSize(width, height);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
}
