package de.stylextv.candle.render.resolution.types;

import de.stylextv.candle.render.resolution.RenderResolution;
import de.stylextv.candle.window.Window;

public class FixedRatioResolution extends RenderResolution {
	
	private int width;
	
	private float ratio;
	
	public FixedRatioResolution(float ratio) {
		this(0, ratio);
	}
	
	public FixedRatioResolution(int width, float ratio) {
		this.width = width;
		this.ratio = ratio;
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return Math.round(width * ratio);
	}
	
	@Override
	public void fitWindow(Window w) {
		int width = w.getWidth();
		int height = w.getHeight();
		
		setWidth(width);
		
		int h = getHeight();
		
		if(h > height) setWidth(Math.round(h / ratio));
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public float getRatio() {
		return ratio;
	}
	
	
}
